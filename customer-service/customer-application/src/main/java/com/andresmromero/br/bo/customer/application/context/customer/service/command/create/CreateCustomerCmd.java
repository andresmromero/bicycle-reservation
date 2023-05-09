package com.andresmromero.br.bo.customer.application.context.customer.service.command.create;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateCustomerCmd(@NotNull UUID id,
                                @NotNull String name,
                                @NotNull String surname,
                                @NotNull String email,
                                @NotNull Integer customerCountryCode,
                                @NotNull Long customerLocalNumber) {}
