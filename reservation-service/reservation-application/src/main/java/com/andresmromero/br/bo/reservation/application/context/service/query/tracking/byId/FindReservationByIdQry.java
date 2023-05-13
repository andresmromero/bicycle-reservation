package com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record FindReservationByIdQry(@NotNull UUID trackingId) {}
