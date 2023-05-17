package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record GetAllCustomerQry(@NotNull UUID id,
                                @NotNull String email,
                                @NotNull String name,
                                @NotNull String surname,
                                @NotNull String nickname) {}
