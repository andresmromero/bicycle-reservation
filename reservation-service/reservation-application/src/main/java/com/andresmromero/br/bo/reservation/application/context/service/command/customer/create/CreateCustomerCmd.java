package com.andresmromero.br.bo.reservation.application.context.service.command.customer.create;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateCustomerCmd(@NotNull UUID id,
                                @NotNull String email,
                                @NotNull String name,
                                @NotNull String surname,
                                @NotNull String nickname) {}
