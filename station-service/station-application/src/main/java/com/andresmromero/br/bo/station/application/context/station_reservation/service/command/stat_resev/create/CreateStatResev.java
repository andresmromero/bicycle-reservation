package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence.StationPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class CreateStatResev {

    private final StationPersSvc stationPersSvc;

    public void create(StationReservEnt adapted) {

        stationPersSvc.save_stationReservEnt(adapted);
    }

}
