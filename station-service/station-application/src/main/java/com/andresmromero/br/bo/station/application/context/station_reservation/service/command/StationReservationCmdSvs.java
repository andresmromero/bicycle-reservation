package com.andresmromero.br.bo.station.application.context.station_reservation.service.command;

import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationRes;

public interface StationReservationCmdSvs {

    ReceiveReservationRes receive_reservation(ReceiveReservationCmd command);

}
