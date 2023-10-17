package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.converter;

import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto.AircraftDTO;
import by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.dao.entity.Aircraft;

public class AircraftConverter {

    public static AircraftDTO convertToDTO(Aircraft aircraft) {
        AircraftDTO aircraftDTO = new AircraftDTO();
        aircraftDTO.setAircraftCode(aircraft.getAircraftCode());
        aircraftDTO.setModel(aircraft.getModel());
        aircraftDTO.setRange(aircraft.getRange());
        return aircraftDTO;
    }

    public static Aircraft convertToEntity(AircraftDTO aircraftDTO) {
        Aircraft aircraft = new Aircraft();
        aircraft.setAircraftCode(aircraftDTO.getAircraftCode());
        aircraft.setModel(aircraftDTO.getModel());
        aircraft.setRange(aircraftDTO.getRange());
        return aircraft;
    }
}

