package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.converter;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.AirportDTO;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Airport;

public class AirportConverter {
    public static AirportDTO convertToDTO(Airport airport) {
        AirportDTO airportDTO = new AirportDTO();
        airportDTO.setAirportCode(airport.getAirportCode());
        airportDTO.setAirportName(airport.getAirportName());
        airportDTO.setCity(airport.getCity());
        airportDTO.setCoordinates(airport.getCoordinates());
        airportDTO.setTimezone(airport.getTimezone());
        return airportDTO;
    }

    public static Airport convertToEntity(AirportDTO airportDTO) {
        Airport entity = new Airport();
        entity.setAirportCode(airportDTO.getAirportCode());
        entity.setAirportName(airportDTO.getAirportName());
        entity.setCity(airportDTO.getCity());
        entity.setCoordinates(airportDTO.getCoordinates());
        entity.setTimezone(airportDTO.getTimezone());
        return entity;
    }
}

