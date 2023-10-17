package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IAircraftDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Aircraft;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AircraftDao implements IAircraftDao {
    private final DataSource dbDateSource;

    private final static String GET_ALL_AIRCRAFTS = "SELECT aircraft_code, model, range\n" +
            "\tFROM bookings.aircrafts_data;";

    public AircraftDao(DataSource dbDateSource) {
        this.dbDateSource = dbDateSource;
    }

    @Override
    public List<Aircraft> getAircrafts() {
        try (Connection connection = dbDateSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_AIRCRAFTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Aircraft> aircrafts = new ArrayList<>();
            while (resultSet.next()) {
                Aircraft aircraft = new Aircraft();
                aircraft.setAircraftCode(resultSet.getString(1));
                aircraft.setModel(resultSet.getString(2));
                aircraft.setRange(resultSet.getInt(3));
                aircrafts.add(aircraft);
            }
            return aircrafts;

        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка получения информации о полетах", e);
        }
    }

}