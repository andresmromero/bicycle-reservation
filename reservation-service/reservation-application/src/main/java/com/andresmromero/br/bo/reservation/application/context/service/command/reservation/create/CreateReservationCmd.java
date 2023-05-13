package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Builder
public record CreateReservationCmd(

        @NotNull UUID customerId,
        @NotNull UUID stationId,
        @NotNull BigDecimal price,
        @NotNull List<CreateReservationCmdItems> itemsList


) {}
