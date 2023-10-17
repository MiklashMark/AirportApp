package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageFormat;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Flight;

import java.util.List;

public interface IFlightService {
    List<Flight> getFlights();

    List<Flight> getPage(PageFormat pageFormat);

    List<Flight> getPage(FlightFilter filter, PageFormat pageFormat);
}
