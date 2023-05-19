package com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID stationId;

    private UUID vehicleId;

    private String stationName;

    private Boolean vehicleIsActive;

    private String vehicleName;

    private BigDecimal vehiclePrice;

    private Boolean vehicleAvailable;
    private UUID vehicleBrand;
    private UUID vehicleModel;
    private Boolean stationActive;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StationResevJpaEnt that = (StationResevJpaEnt) o;
        return id.equals(that.id) && Objects.equals(stationId, that.stationId) &&
                Objects.equals(vehicleId, that.vehicleId) && Objects.equals(stationName, that.stationName) &&
                Objects.equals(vehicleIsActive, that.vehicleIsActive) &&
                Objects.equals(vehicleName, that.vehicleName) && Objects.equals(vehiclePrice, that.vehiclePrice) &&
                Objects.equals(vehicleAvailable, that.vehicleAvailable) &&
                Objects.equals(vehicleBrand, that.vehicleBrand) && Objects.equals(vehicleModel, that.vehicleModel) &&
                Objects.equals(stationActive, that.stationActive);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id,
                            stationId,
                            vehicleId,
                            stationName,
                            vehicleIsActive,
                            vehicleName,
                            vehiclePrice,
                            vehicleAvailable,
                            vehicleBrand,
                            vehicleModel,
                            stationActive);
    }

}