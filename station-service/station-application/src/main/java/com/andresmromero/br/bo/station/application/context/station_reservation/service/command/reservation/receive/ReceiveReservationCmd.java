package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;

@Builder
public record ReceiveReservationCmd(

        @NotNull String id,
        @NotNull String stationId,
        @NotNull String reservationId,
        @NotNull String status,
        @NotNull List<ReceiveResevCmdItems> vehicles,
        @NotNull BigDecimal price

) {


}
