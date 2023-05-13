package com.andresmromero.br.bo.reservation.application.context.service.command;

import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmdRes;

public interface ReservationCmdSvc {

    CreateReservationCmdRes create_reservation(CreateReservationCmd command);

}
