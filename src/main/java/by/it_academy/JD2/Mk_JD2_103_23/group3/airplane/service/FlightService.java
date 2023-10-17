package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageFormat;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Flight;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IFlightService;

import java.util.List;

public class FlightService implements IFlightService {
    IFlightDao flightDao;

    public FlightService(IFlightDao flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<Flight> getFlights() {
        return flightDao.getFlights();
    }
    @Override
    public List<Flight> getPage(PageFormat pageFormat) {
        return this.flightDao.getPage(pageFormat);
    }

    @Override
    public List<Flight> getPage(FlightFilter filter, PageFormat pageFormat) {

        return this.flightDao.getPage(filter, pageFormat);
    }
}
