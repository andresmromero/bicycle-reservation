package com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "station_reservation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StationResevJpaEnt {

    @Id
    private UUID stationId;

    private UUID vehicleId;

    private String stationName;

    private Boolean vehicleIsActive;

    private String vehicleName;

    private BigDecimal vehiclePrice;

    private Boolean vehicleAvailable;
    private UUID vehicleBrand;
    private UUID vehicleModel;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StationResevJpaEnt that = (StationResevJpaEnt) o;
        return stationId.equals(that.stationId) && Objects.equals(vehicleId, that.vehicleId) &&
                Objects.equals(stationName, that.stationName) &&
                Objects.equals(vehicleIsActive, that.vehicleIsActive) &&
                Objects.equals(vehicleName, that.vehicleName) && Objects.equals(vehiclePrice, that.vehiclePrice) &&
                Objects.equals(vehicleAvailable, that.vehicleAvailable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stationId,
                            vehicleId,
                            stationName,
                            vehicleIsActive,
                            vehicleName,
                            vehiclePrice,
                            vehicleAvailable);
    }

}