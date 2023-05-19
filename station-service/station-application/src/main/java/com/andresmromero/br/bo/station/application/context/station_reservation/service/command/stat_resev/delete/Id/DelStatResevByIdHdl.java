package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.delete.Id;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class DelStatResevByIdHdl {

    private final DelByIdStatResev delete;

    @Transactional
    public void invoke(DelStatResevByIdCmd command) {

        delete.delete_by_id(command.id());
    }

}
