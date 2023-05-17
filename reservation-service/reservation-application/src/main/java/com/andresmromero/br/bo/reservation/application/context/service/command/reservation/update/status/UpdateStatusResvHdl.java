package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class UpdateStatusResvHdl {

    private final UpdateStatusResv updateStatusResv;

    public UpdateStatusResvCmdRes handle(UpdateStatusResvCmd command) {

        return updateStatusResv.invoke(command);

    }

}
