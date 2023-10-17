package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.controller.servlets.ui;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.converter.AircraftConverter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.AircraftDTO;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Aircraft;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAircraftService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory.AircraftServiceFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/aircraft")
public class UiAircraftServlet extends HttpServlet {
    private IAircraftService aircraftService = AircraftServiceFactory.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AircraftDTO> aircraftsDTOS = aircraftService.getAircrafts()
                .stream()
                .map(AircraftConverter::convertToDTO)
                .collect(Collectors.toList());

        req.setAttribute("data", aircraftsDTOS);
        req.getRequestDispatcher("/ui/aircrafts.jsp").forward(req,resp);
    }
}
