package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.converter.AirportConverter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.AirportDTO;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirportService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.AirportServiceFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/api/airport")
public class AirportServletJson extends HttpServlet {
    private final IAirportService airportService = AirportServiceFactory.getInstance();
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AirportDTO> airportDTOS = airportService.getAirports()
                .stream()
                .map(AirportConverter::convertToDTO)
                .collect(Collectors.toList());

        resp.getWriter().write(mapper.writeValueAsString(airportDTOS));

    }
}