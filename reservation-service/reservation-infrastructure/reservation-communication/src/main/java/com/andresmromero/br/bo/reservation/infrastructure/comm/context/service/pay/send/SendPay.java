package com.andresmromero.br.bo.reservation.infrastructure.comm.context.service.pay.send;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record SendPay(@NotNull UUID id, UUID reservationId, @NotNull UUID customerId, @NotNull BigDecimal price,

                      @NotNull String paymentStatus

) {

    public SendPay withGenericValues(UUID reservationId) {

        return new SendPay(id(), reservationId, customerId(), price(), paymentStatus());
    }

}
