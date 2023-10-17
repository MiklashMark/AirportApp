package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.converter;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.FlightDTO;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Flight;

public class FlightConverter {
    public static FlightDTO convertToDTO(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setFlightId(flight.getFlightId());
        flightDTO.setFlightNo(flight.getFlightNo());
        flightDTO.setScheduledDeparture(flight.getScheduledDeparture());
        flightDTO.setScheduledDepartureLocal(flight.getScheduledDepartureLocal());
        flightDTO.setScheduledArrival(flight.getScheduledArrival());
        flightDTO.setScheduledArrivalLocal(flight.getScheduledArrivalLocal());
        flightDTO.setScheduledDuration(flight.getScheduledDuration());
        flightDTO.setDepartureAirport(flight.getDepartureAirport());
        flightDTO.setDepartureAirportName(flight.getDepartureAirportName());
        flightDTO.setDepartureCity(flight.getDepartureCity());
        flightDTO.setArrivalAirport(flight.getArrivalAirport());
        flightDTO.setArrivalAirportName(flight.getArrivalAirportName());
        flightDTO.setArrivalCity(flight.getArrivalCity());
        flightDTO.setStatus(flight.getStatus());
        flightDTO.setAircraftCode(flight.getAircraftCode());
        flightDTO.setActualDeparture(flight.getActualDeparture());
        flightDTO.setActualDepartureLocal(flight.getActualDepartureLocal());
        flightDTO.setActualArrival(flight.getActualArrival());
        flightDTO.setActualArrivalLocal(flight.getActualArrivalLocal());
        flightDTO.setActualDuration(flight.getActualDuration());
        return flightDTO;
    }

    public static Flight convertToEntity(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setFlightId(flightDTO.getFlightId());
        flight.setFlightNo(flightDTO.getFlightNo());
        flight.setScheduledDeparture(flightDTO.getScheduledDeparture());
        flight.setScheduledDepartureLocal(flightDTO.getScheduledDepartureLocal());
        flight.setScheduledArrival(flightDTO.getScheduledArrival());
        flight.setScheduledArrivalLocal(flightDTO.getScheduledArrivalLocal());
        flight.setScheduledDuration(flightDTO.getScheduledDuration());
        flight.setDepartureAirport(flightDTO.getDepartureAirport());
        flight.setDepartureAirportName(flightDTO.getDepartureAirportName());
        flight.setDepartureCity(flightDTO.getDepartureCity());
        flight.setArrivalAirport(flightDTO.getArrivalAirport());
        flight.setArrivalAirportName(flightDTO.getArrivalAirportName());
        flight.setArrivalCity(flightDTO.getArrivalCity());
        flight.setStatus(flightDTO.getStatus());
        flight.setAircraftCode(flightDTO.getAircraftCode());
        flight.setActualDeparture(flightDTO.getActualDeparture());
        flight.setActualDepartureLocal(flightDTO.getActualDepartureLocal());
        flight.setActualArrival(flightDTO.getActualArrival());
        flight.setActualArrivalLocal(flightDTO.getActualArrivalLocal());
        flight.setActualDuration(flightDTO.getActualDuration());
        return flight;
    }
}