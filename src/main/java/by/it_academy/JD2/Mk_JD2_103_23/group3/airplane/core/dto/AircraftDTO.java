package by.it_academy.JD2.Mk_JD2_103_23.group3.airplane.core.dto;

import java.util.Objects;

public class AircraftDTO {
    private String aircraftCode;
    private String model;
    private Integer range;

    public AircraftDTO() {
    }

    public AircraftDTO(String aircraftCode, String model, Integer range) {
        this.aircraftCode = aircraftCode;
        this.model = model;
        this.range = range;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public void setAircraftCode(String aircraftCode) {
        this.aircraftCode = aircraftCode;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AircraftDTO aircraft = (AircraftDTO) o;

        if (!Objects.equals(aircraftCode, aircraft.aircraftCode))
            return false;
        if (!Objects.equals(model, aircraft.model)) return false;
        return Objects.equals(range, aircraft.range);
    }

    @Override
    public int hashCode() {
        int result = aircraftCode != null ? aircraftCode.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (range != null ? range.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraftCode='" + aircraftCode + '\'' +
                ", model='" + model + '\'' +
                ", range=" + range +
                '}';
    }
}
