package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.factory;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.FlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.data_source.DBDateSource;

public class FlightDaoFactory {
    private volatile static FlightDao instance;

    private FlightDaoFactory(){
    }

    public static IFlightDao getInstance(){
        if (instance == null) {
            synchronized (FlightDaoFactory.class) {
                if (instance == null) {
                   instance = new FlightDao(DBDateSource.getInstance());
                }
            }
        }
        return instance;
    }
}
