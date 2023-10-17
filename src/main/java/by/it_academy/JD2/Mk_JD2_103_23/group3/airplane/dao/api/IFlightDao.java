package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageFormat;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Flight;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface IFlightDao {
    List<Flight> getFlights();
    Flight map(ResultSet resultSet) throws SQLException;

    List<Flight> getPage(FlightFilter flightFilter, PageFormat pageFormat);
    List<Flight> getPage(PageFormat pageFormat);

    int getFlightsCount();
}
