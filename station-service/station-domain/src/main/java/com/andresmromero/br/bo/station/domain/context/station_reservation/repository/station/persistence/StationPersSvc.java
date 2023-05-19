package com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence;

import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationReceivedStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface StationPersSvc {

    Optional<StationAgg> get_station(StationAgg station);

    ReservationReceivedStn save_received(ReservationReceivedStn reservationReceived);

    List<StationReservEnt> pers_find_By_StationId_VehicleId_In(UUID stationId, List<UUID> vehicleIds);


    StationReservEnt save_stationReservEnt(StationReservEnt stationReservEnt);

    void delete_stationReservEnt(UUID reservationId);

    StationReservEnt update_by_reservationId(UUID reservationId, StationReservEnt stationReservEnt);

}
