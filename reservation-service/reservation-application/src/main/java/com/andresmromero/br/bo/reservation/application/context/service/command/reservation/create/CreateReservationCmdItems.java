package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record CreateReservationCmdItems(@NotNull String name,
                                        @NotNull BigDecimal price,
                                        @NotNull UUID vehicleId,
                                        @NotNull Integer quantity,
                                        @NotNull BigDecimal total

) {}
