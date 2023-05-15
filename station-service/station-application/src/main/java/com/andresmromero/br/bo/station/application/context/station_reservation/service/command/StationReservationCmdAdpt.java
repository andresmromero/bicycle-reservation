package com.andresmromero.br.bo.station.application.context.station_reservation.service.command;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationHdl;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationRes;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class StationReservationCmdAdpt implements StationReservationCmdSvs {

    private final ReceiveReservationHdl receivedPaymentHdl;


    @Override
    public ReceiveReservationRes receive_reservation(ReceiveReservationCmd command) {

        return receivedPaymentHdl.handle(command);

    }

}
