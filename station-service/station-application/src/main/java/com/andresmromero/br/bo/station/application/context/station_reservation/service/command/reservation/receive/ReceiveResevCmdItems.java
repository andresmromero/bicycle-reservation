package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ReceiveResevCmdItems(@NotNull String name,
                                   @NotNull UUID vehicleId,
                                   @NotNull BigDecimal price,
                                   @NotNull Integer quantity,
                                   @NotNull Integer available

) {}
