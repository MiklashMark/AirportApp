package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.factory;


import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.AircraftDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IAircraftDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.data_source.DBDateSource;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class AircraftDaoFactory {
    private volatile static AircraftDao instance;

    private AircraftDaoFactory(){
    }

    public static IAircraftDao getInstance()  {
        if (instance == null) {
            synchronized (AircraftDaoFactory.class) {
                if (instance == null) {
                        instance = new AircraftDao(DBDateSource.getInstance());
                }
            }
        }
        return instance;
    }
}
