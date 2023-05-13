package com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId;

import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@Builder
public record FindReservationByIdQryRes(

        @NotNull UUID trackingId, @NotNull ReservationStatus reservationStatus, List<String> messages

) {

}
