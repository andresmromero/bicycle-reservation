package com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateResevCustomerByIdCmd(UUID id,
                                         @NotNull String email,
                                         @NotNull String name,
                                         @NotNull String surname,
                                         @NotNull String nickname) {


    public UpdateResevCustomerByIdCmd withId(UUID id) {

        return new UpdateResevCustomerByIdCmd(id, email(), name(), surname(), nickname());
    }

}
