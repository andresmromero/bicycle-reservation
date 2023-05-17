package com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DeleteCustomerByIdCmd(@NotNull UUID id) {

    public DeleteCustomerByIdCmd(UUID id) {

        this.id = id;
    }

}
