package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class ReceiveReservationHdl {

    private final ReceiveReservation receivedPayment;

    public ReceiveReservationRes handle(ReceiveReservationCmd command) {

        return receivedPayment.invoke(command);

    }

}
