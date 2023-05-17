package com.andresmromero.br.bo.pay.infrastructure.comm.context.send;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record SendPayment(@NotNull UUID id, UUID reservationId, @NotNull UUID customerId, @NotNull BigDecimal price,

                          @NotNull String paymentStatus

) {

    public SendPayment withGenericValues(UUID reservationId) {

        return new SendPayment(id(), reservationId, customerId(), price(), paymentStatus());
    }

}
