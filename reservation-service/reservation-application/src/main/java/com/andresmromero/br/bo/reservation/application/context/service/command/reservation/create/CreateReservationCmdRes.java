package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record CreateReservationCmdRes(@NotNull List<String> message) {

}
