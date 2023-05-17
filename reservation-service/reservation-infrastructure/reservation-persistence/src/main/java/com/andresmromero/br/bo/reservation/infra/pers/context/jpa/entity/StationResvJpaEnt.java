package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "station")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StationResvJpaEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID stationId;
    private String stationName;
    private Boolean stationActive;

    private UUID vehicleId;
    private String vehicleName;
    private BigDecimal VehiclePrice;
    private UUID vehicleBrand;
    private UUID vehicleModel;
    private Boolean VehicleAvailable;


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StationResvJpaEnt that = (StationResvJpaEnt) o;
        return stationId.equals(that.stationId) && vehicleId.equals(that.vehicleId) &&
                Objects.equals(stationName, that.stationName) && Objects.equals(stationActive, that.stationActive) &&
                Objects.equals(vehicleName, that.vehicleName) && Objects.equals(VehiclePrice, that.VehiclePrice) &&
                Objects.equals(VehicleAvailable, that.VehicleAvailable);
    }

    @Override
    public int hashCode() {

        return Objects.hash(stationId,
                            vehicleId,
                            stationName,
                            stationActive,
                            vehicleName,
                            VehiclePrice,
                            VehicleAvailable);
    }

}
