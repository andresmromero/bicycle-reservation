package com.andresmromero.br.bo.reservation.application.context.service.command.customer.delete.byId;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DeleteCustomerByIdCmd(@NotNull UUID id) {

    public DeleteCustomerByIdCmd(UUID id) {

        this.id = id;
    }

}
