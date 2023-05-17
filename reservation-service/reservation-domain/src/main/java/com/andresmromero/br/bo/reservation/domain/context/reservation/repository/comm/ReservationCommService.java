package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.comm;

import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.response.ReservationDomRes;

public interface ReservationCommService {

    void send_payment(ReservationDomRes ReservationDomRes, PaymentStatus paymentStatus);

}
