package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.resp;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record GetCustomerByIdQryResp(@NotNull UUID id,
                                     @NotNull String name,
                                     @NotNull String surname,
                                     @NotNull String email,
                                     @NotNull String nickname) {}
