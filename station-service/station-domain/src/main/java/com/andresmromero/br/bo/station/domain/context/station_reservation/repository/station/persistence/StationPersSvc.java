package com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence;

import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationReceivedStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;

import java.util.Optional;

public interface StationPersSvc {

    Optional<StationAgg> get_station(StationAgg station);

    ReservationReceivedStn save_received(ReservationReceivedStn reservationReceived);

}
