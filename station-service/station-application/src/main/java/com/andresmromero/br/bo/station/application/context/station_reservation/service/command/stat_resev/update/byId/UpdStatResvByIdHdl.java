package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.application.context.station_reservation.mapper.StationReservationAppMpr;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class UpdStatResvByIdHdl {

    private final UpdByIdStatResev update;
    private final StationReservationAppMpr stationReservationAppMpr;


    @Transactional
    public void invoke(UpdStatResevIdCmd command) {

        StationReservEnt model = stationReservationAppMpr.updateStatResevByIdCmd_to_stationReservEnt(command);
        update.update_by_id(model);
    }

}
