package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.delete.Id;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence.StationPersSvc;
import lombok.AllArgsConstructor;

import java.util.UUID;

@ApplicationComp
@AllArgsConstructor
public class DelByIdStatResev {

    private final StationPersSvc stationPersSvc;

    public void delete_by_id(UUID reservationId) {

        stationPersSvc.delete_stationReservEnt(reservationId);

    }

}
