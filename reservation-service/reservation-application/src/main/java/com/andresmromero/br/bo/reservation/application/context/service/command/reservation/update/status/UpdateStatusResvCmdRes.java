package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record UpdateStatusResvCmdRes(@NotNull List<String> message) {

}
