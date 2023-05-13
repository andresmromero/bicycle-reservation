package com.andresmromero.br.bo.reservation.application.context.service.command;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmdRes;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationHdl;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class ReservationCmdAdpt implements ReservationCmdSvc {

    private final CreateReservationHdl createReservationHdl;

    @Override
    public CreateReservationCmdRes create_reservation(CreateReservationCmd command) {

        return createReservationHdl.handle(command);
    }

}
