package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence.StationPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class UpdByIdStatResev {

    private final StationPersSvc stationPersSvc;


    public void update_by_id(StationReservEnt adapted) {

        stationPersSvc.update_by_reservationId(adapted.getStationId(), adapted);

    }

}
