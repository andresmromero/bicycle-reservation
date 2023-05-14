package com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record CanceledPaymentCmd(@NotNull UUID id,
                                 UUID reservationId,
                                 @NotNull UUID customerId,
                                 @NotNull BigDecimal price,

                                 @NotNull String paymentStatus

) {

    public CanceledPaymentCmd withGenericValues(UUID reservationId) {

        return new CanceledPaymentCmd(id(), reservationId, customerId(), price(), paymentStatus());
    }

}
