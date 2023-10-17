package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IAircraftDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Aircraft;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAircraftService;

import java.util.List;

public class AircraftService implements IAircraftService {
    private IAircraftDao aircraftDao;
    public AircraftService(IAircraftDao instance) {
        this.aircraftDao = instance;
    }

    @Override
    public List<Aircraft> getAircrafts() {
       return aircraftDao.getAircrafts();
    }
}
