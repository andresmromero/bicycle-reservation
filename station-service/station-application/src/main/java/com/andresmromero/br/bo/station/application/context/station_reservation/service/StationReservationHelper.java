package com.andresmromero.br.bo.station.application.context.station_reservation.service;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.application.context.station_reservation.exception.StationReservationAppExc;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationReceivedStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence.StationPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class StationReservationHelper {

    private final StationPersSvc stationPersSvc;

    public StationAgg get_station(StationAgg station) {

        return stationPersSvc.get_station(station).orElseThrow(() -> new StationReservationAppExc("Station no found"));

    }


    public void save_reservation_received(ReservationReceivedStn reservationReceived) {

        stationPersSvc.save_received(reservationReceived);
    }

}
