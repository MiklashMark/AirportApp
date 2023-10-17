package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.facrtory;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.factory.AircraftDaoFactory;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.AircraftService;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.service.api.IAircraftService;

public class AircraftServiceFactory {
    private volatile static AircraftService instance;

    private AircraftServiceFactory() {
    }

    public static IAircraftService getInstance() {
        if (instance == null) {
            synchronized (AircraftServiceFactory.class) {
                if (instance == null) {
                    instance = new AircraftService(AircraftDaoFactory.getInstance());
                }
            }
        }
        return instance;
    }
}
