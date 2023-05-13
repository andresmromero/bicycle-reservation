package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class CreateReservationHdl {

    private final CreateReservation createReservation;

    public CreateReservationCmdRes handle(CreateReservationCmd command) {


        return createReservation.invoke(command);

    }

}
