package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightFilter;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.PageFormat;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.api.IFlightDao;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Flight;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDao implements IFlightDao {
    private final static String GET_ALL_FLIGHTS = "SELECT flight_id, flight_no, scheduled_departure," +
            " scheduled_departure_local, scheduled_arrival, scheduled_arrival_local, scheduled_duration," +
            " departure_airport, departure_airport_name, departure_city, arrival_airport, arrival_airport_name," +
            " arrival_city, status, aircraft_code, actual_departure, actual_departure_local, actual_arrival," +
            " actual_arrival_local, actual_duration\n" +
            "\tFROM bookings.flights_v";
    private final static String GET_COUNT_FLIGHT = "SELECT count(*) FROM bookings.flights_v;";
    DataSource dataSource;

    public FlightDao(DataSource instance) {
        this.dataSource = instance;
    }

    @Override
    public List<Flight> getFlights() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_FLIGHTS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            List<Flight> flights = new ArrayList<>();
            while (resultSet.next()) {
                flights.add(map(resultSet));
            }
            return flights;

        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка получении о полетах", e);
        }
    }

    @Override
    public List<Flight> getPage(FlightFilter flightFilter, PageFormat pageFormat) {
        String sql = GET_ALL_FLIGHTS;

        List<Object> filters = new ArrayList<>();
        boolean needSeparator = false;

        if (flightFilter != null) {
            StringBuilder sqlBuilder = new StringBuilder();
            
            if (flightFilter.getArrivalAirport() != null) {
                if (needSeparator) {
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("arrival_airport = ?");
                filters.add(flightFilter.getArrivalAirport());
            }
            
            if(flightFilter.getDepartureAirport() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("departure_airport = ?");
                filters.add(flightFilter.getDepartureAirport());
            }
            
            if(flightFilter.getStatus() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("status = ?");
                filters.add(flightFilter.getStatus());
            }
            
            if(flightFilter.getScheduledDeparture() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("scheduled_departure >= ? AND scheduled_departure < ?");
                filters.add(flightFilter.getScheduledDeparture());
                filters.add(flightFilter.getScheduledDeparture().plusDays(1));
            }
            
            if(flightFilter.getScheduledArrival() != null){
                if(needSeparator){
                    sqlBuilder.append(" AND ");
                } else {
                    needSeparator = true;
                }
                sqlBuilder.append("scheduled_arrival >= ? AND scheduled_arrival < ?");
                filters.add(flightFilter.getScheduledArrival());
                filters.add(flightFilter.getScheduledArrival().plusDays(1));
            }
            if(sqlBuilder.length() > 0){
                sqlBuilder.insert(0, " WHERE ");
                sql += sqlBuilder.toString();
            }
        }
        if(pageFormat != null){
            int size = pageFormat.getSize();
            int page = pageFormat.getPage();

            sql += " LIMIT ? OFFSET ?";
            filters.add(size);
            filters.add(((page - 1) * size));
        }

        try (Connection conn = dataSource.getConnection();
             PreparedStatement stm = conn.prepareStatement(sql);
        )
        {
            int index = 1;
            for (Object param : filters) {
                stm.setObject(index++, param);
            }

            try(ResultSet rs = stm.executeQuery();){
                List<Flight> data = new ArrayList<>();
                while (rs.next()){
                    data.add(map(rs));
                }
                return data;
            }
        } catch (SQLException e){
            throw new IllegalStateException("Ошибка получения информации об аэропортах", e);
        }
    }

    @Override
    public List<Flight> getPage(PageFormat pageFormat) {
        return getPage(null, pageFormat);
    }

    @Override
    public int getFlightsCount() {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(GET_COUNT_FLIGHT);
             ResultSet resultSet = preparedStatement.executeQuery()) {
             while (resultSet.next()) {
                 return resultSet.getInt(1);
             }
            return 0;
        } catch (SQLException e) {
            throw new IllegalStateException("Ошибка получении о полетах", e);
        }
    }

    @Override
    public Flight map(ResultSet resultSet) throws SQLException {
        Flight flight = new Flight();
        flight.setFlightId(resultSet.getString("flight_id"));
        flight.setFlightNo(resultSet.getString("flight_no"));
        flight.setScheduledDeparture(resultSet.getString("scheduled_departure"));
        flight.setScheduledDepartureLocal(resultSet.getString("scheduled_departure_local"));
        flight.setScheduledArrival(resultSet.getString("scheduled_arrival"));
        flight.setScheduledArrivalLocal(resultSet.getString("scheduled_arrival_local"));
        flight.setScheduledDuration(resultSet.getString("scheduled_duration"));
        flight.setDepartureAirport(resultSet.getString("departure_airport"));
        flight.setDepartureAirportName(resultSet.getString("departure_airport_name"));
        flight.setDepartureCity(resultSet.getString("departure_city"));
        flight.setArrivalAirport(resultSet.getString("arrival_airport"));
        flight.setArrivalAirportName(resultSet.getString("arrival_airport_name"));
        flight.setArrivalCity(resultSet.getString("arrival_city"));
        flight.setStatus(resultSet.getString("status"));
        flight.setAircraftCode(resultSet.getString("aircraft_code"));
        flight.setActualDeparture(resultSet.getString("actual_departure"));
        flight.setActualDepartureLocal(resultSet.getString("actual_departure_local"));
        return flight;
    }
}
