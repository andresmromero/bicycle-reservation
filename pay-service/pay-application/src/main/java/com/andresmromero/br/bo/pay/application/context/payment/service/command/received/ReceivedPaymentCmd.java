package com.andresmromero.br.bo.pay.application.context.payment.service.command.received;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record ReceivedPaymentCmd(@NotNull UUID id,
                                 UUID reservationId,
                                 @NotNull UUID customerId,
                                 @NotNull BigDecimal price,

                                 @NotNull String paymentStatus

) {

    public ReceivedPaymentCmd withGenericValues(UUID reservationId) {

        return new ReceivedPaymentCmd(id(), reservationId, customerId(), price(), paymentStatus());
    }

}
