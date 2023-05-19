package com.andresmromero.br.bo.reservation.infrastructure.comm.context.adapter;

import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.comm.ReservationCommService;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableComm;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableQryComm;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.response.ReservationDomRes;
import com.andresmromero.br.bo.reservation.infrastructure.comm.context.http.PayHttpCommRest;
import com.andresmromero.br.bo.reservation.infrastructure.comm.context.http.StationHttpCommRest;
import com.andresmromero.br.bo.reservation.infrastructure.comm.context.service.pay.send.SendPay;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@InfrastructureSvc
public class ResevCommAdapter implements ReservationCommService {

    private final PayHttpCommRest payHttpCommRest;
    private final StationHttpCommRest stationHttpCommRest;

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

    @Override
    public GetAvailableQryComm get_station(GetAvailableComm query) {

        GetAvailableQryComm availableList = stationHttpCommRest.get_available(query);
        return availableList;
    }

}
