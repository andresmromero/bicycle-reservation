package com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;

import java.util.Optional;

public interface PaymentPersSvc {

    PaymentAgg save(PaymentAgg payment);

    Optional<PaymentAgg> get_by_reservationId(ReservationId reservationId);

}
