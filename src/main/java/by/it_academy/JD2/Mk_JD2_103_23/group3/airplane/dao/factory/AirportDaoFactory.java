package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.factory;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.AirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IAirportDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.data_source.DBDateSource;


public class AirportDaoFactory {
    private volatile static AirportDao instance;

    private AirportDaoFactory(){
    }

    public static IAirportDao getInstance()  {
        if (instance == null) {
            synchronized (AirportDaoFactory.class) {
                if (instance == null) {
                   instance = new AirportDao(DBDateSource.getInstance());
                }
            }
        }
        return instance;
    }
}