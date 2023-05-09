package com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UpdateCustomerByIdCmd(UUID id,
                                    @NotNull String name,
                                    @NotNull String surname,
                                    @NotNull String email,
                                    @NotNull Integer customerCountryCode,
                                    @NotNull Long customerLocalNumber) {


    public UpdateCustomerByIdCmd withId(UUID id) {

        return new UpdateCustomerByIdCmd(id, name(), surname(), email(), customerCountryCode(), customerLocalNumber());
    }

}
