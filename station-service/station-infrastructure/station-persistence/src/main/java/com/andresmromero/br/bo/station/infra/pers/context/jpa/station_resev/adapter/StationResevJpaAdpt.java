package com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationReceivedStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence.StationPersSvc;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.mapper.StationJpaMpr;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity.ResevReceiveJpaEnt;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity.StationResevJpaEnt;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.repository.ResevReceiveJpaRepo;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.repository.StationResevJpaRepo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@InfrastructureSvc
@AllArgsConstructor
public class StationResevJpaAdpt implements StationPersSvc {

    private final ResevReceiveJpaRepo reservationReceiveJpaRepo;
    private final StationResevJpaRepo stationReservationJpaRepo;
    private final StationJpaMpr stationInfraMpr;

    @Override
    public Optional<StationAgg> get_station(StationAgg station) {

        List<UUID> StationVehicles = stationInfraMpr.station_to_stationVehicles(station);

        Optional<List<StationResevJpaEnt>> stationEntityList =
                stationReservationJpaRepo.findByStationIdAndVehicleIdIn(station.getId().getValue(), StationVehicles);

        return stationEntityList.map(stationInfraMpr::stationReservationEntity_to_StationReservation);
    }

    @Override
    public ReservationReceivedStn save_received(ReservationReceivedStn reservationReceived) {

        ResevReceiveJpaEnt toEntity =
                stationInfraMpr.reservationReceive_to_reservationReceiveEntity(reservationReceived);
        reservationReceiveJpaRepo.save(toEntity);
        return reservationReceived;

    }

}
