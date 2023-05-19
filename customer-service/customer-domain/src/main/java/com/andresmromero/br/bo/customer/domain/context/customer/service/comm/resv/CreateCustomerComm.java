package com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateCustomerComm(@NotNull UUID id,
                                 @NotNull String email,
                                 @NotNull String name,
                                 @NotNull String surname,
                                 @NotNull String nickname) {

}
