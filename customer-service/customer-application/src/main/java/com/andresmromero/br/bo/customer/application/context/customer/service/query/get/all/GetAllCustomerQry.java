package com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record GetAllCustomerQry(@NotNull UUID id,
                                @NotNull String name,
                                @NotNull String surname,
                                @NotNull String email,
                                @NotNull Integer customerCountryCode,
                                @NotNull Long customerLocalNumber) {}
