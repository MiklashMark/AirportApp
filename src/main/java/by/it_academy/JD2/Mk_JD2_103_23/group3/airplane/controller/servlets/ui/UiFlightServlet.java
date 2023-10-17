package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets.ui;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.converter.FlightConverter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightDTO;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageFormat;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IFlightService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.FlightServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/flight")
public class UiFlightServlet extends HttpServlet {
    private static final String PAGE_PARAM = "page";
    private static final String SIZE_PARAM = "size";

    private static final String SCHEDULED_DEPARTURE_PARAM = "scheduled_departure";
    private static final String SCHEDULED_ARRIVAL_PARAM = "scheduled_arrival";
    private static final String DEPARTURE_AIRPORT_PARAM = "departure_airport";
    private static final String ARRIVAL_AIRPORT_PARAM = "arrival_airport";
    private static final String STATUS_PARAM = "status";
    private final IFlightService flightService = FlightServiceFactory.getInstance();
    private  final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String scheduledDepartureRaw = req.getParameter(SCHEDULED_DEPARTURE_PARAM);
        LocalDate scheduledDeparture = null;
        if (scheduledDepartureRaw != null && !scheduledDepartureRaw.isBlank()) {
            scheduledDeparture = LocalDate.parse(scheduledDepartureRaw, formatter);
        }

        String scheduledArrivalRaw = req.getParameter(SCHEDULED_ARRIVAL_PARAM);
        LocalDate scheduledArrival = null;
        if (scheduledArrivalRaw != null && !scheduledArrivalRaw.isBlank()) {
            scheduledArrival = LocalDate.parse(scheduledArrivalRaw, formatter);
        }

        String departureAirport = req.getParameter(DEPARTURE_AIRPORT_PARAM);
        String arrivalAirport = req.getParameter(ARRIVAL_AIRPORT_PARAM);
        String status = req.getParameter(STATUS_PARAM);

        String pageRaw = req.getParameter(PAGE_PARAM);
        int page;
        if (pageRaw == null || pageRaw.isBlank()) {
            page = 5;
        } else {
            page = Integer.parseInt(pageRaw);
        }

        String sizeRaw = req.getParameter(SIZE_PARAM);
        int size;
        if (sizeRaw == null || sizeRaw.isBlank()) {
            size = 10;
        } else {
            size = Integer.parseInt(sizeRaw);
        }

        PageFormat pageFormat = new PageFormat(page, size);
        FlightFilter flightFilter = new FlightFilter(scheduledDeparture, scheduledArrival, departureAirport,
                arrivalAirport, status);

        List<FlightDTO> flightDTOS = flightService.getPage(flightFilter, pageFormat)
                .stream()
                .map(FlightConverter::convertToDTO)
                .collect(Collectors.toList());

        req.setAttribute("data", flightDTOS);
        req.getRequestDispatcher("/ui/flights.jsp").forward(req, resp);
    }
}
