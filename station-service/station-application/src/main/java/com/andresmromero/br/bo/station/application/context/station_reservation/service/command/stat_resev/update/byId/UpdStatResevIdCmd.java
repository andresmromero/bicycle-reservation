package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record UpdStatResevIdCmd(UUID stationId,

                                @NotNull UUID vehicleId,

                                @NotNull String stationName,

                                @NotNull Boolean vehicleIsActive,

                                @NotNull String vehicleName,

                                @NotNull BigDecimal vehiclePrice,

                                @NotNull Boolean vehicleAvailable,
                                @NotNull UUID vehicleBrand,
                                @NotNull UUID vehicleModel,
                                @NotNull Boolean stationActive) {

    public UpdStatResevIdCmd withId(UUID id) {

        return new UpdStatResevIdCmd(id,
                                     vehicleId(),
                                     stationName(),
                                     vehicleIsActive(),
                                     vehicleName(),
                                     vehiclePrice(),
                                     vehicleAvailable(),
                                     vehicleBrand(),
                                     vehicleModel(),
                                     stationActive());
    }

}
