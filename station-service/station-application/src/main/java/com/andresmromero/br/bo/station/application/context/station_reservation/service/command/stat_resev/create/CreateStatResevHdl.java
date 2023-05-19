package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.application.context.station_reservation.mapper.StationReservationAppMpr;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class CreateStatResevHdl {

    private final CreateStatResev create;
    private final StationReservationAppMpr stationReservationAppMpr;

    @Transactional
    public void invoke(CreateStatResevCmd command) {

        StationReservEnt model = stationReservationAppMpr.createStatResevCmd_to_stationReservEnt(command);
        create.create(model);
    }

}
