package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateStatusResvCmd(

        UUID reservationId, @NotNull String conditional, @NotNull String newStatus

) {


    public UpdateStatusResvCmd withReservationId(UUID reservationId) {

        return new UpdateStatusResvCmd(reservationId, conditional(), newStatus());
    }

}
