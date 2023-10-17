package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IAirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Airport;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAirportService;

import java.util.List;

public class AirportService implements IAirportService {
    IAirportDao airportDao;

    public AirportService(IAirportDao airportDao) {
        this.airportDao = airportDao;
    }

    @Override
    public List<Airport> getAirports() {
        return airportDao.getAirports();
    }
}
