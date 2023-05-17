package com.andresmromero.br.bo.reservation.infrastructure.comm.context.adapter;

import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.comm.ReservationCommService;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.response.ReservationDomRes;
import com.andresmromero.br.bo.reservation.infrastructure.comm.context.http.PayHttpCommRest;
import com.andresmromero.br.bo.reservation.infrastructure.comm.context.service.pay.send.SendPay;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@InfrastructureSvc
public class ResevCommAdapter implements ReservationCommService {

    private final PayHttpCommRest payHttpCommRest;


    @Override
    public void send_payment(ReservationDomRes rdr, PaymentStatus paymentStatus) {

        UUID value = rdr.getReservation().getId().getValue();
        SendPay sendPayment = SendPay.builder()

                                     .id(UUID.randomUUID())
                                     .reservationId(value)
                                     .customerId(rdr.getReservation().getCustomerId().getValue())
                                     .price(rdr.getReservation().getPrice().getAmount())
                                     .paymentStatus(paymentStatus.name())
                                     .build();

        payHttpCommRest.receive_payment(value, sendPayment);
    }

}
