package com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationReceivedStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence.StationPersSvc;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.exception.StationResevInfraExc;
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

        ReservationReceivedStn elem = reservationReceived;

        ResevReceiveJpaEnt toEntity =
                stationInfraMpr.reservationReceive_to_reservationReceiveEntity(reservationReceived);
        reservationReceiveJpaRepo.save(toEntity);
        return reservationReceived;

    }

    @Override
    public List<StationReservEnt> pers_find_By_StationId_VehicleId_In(UUID stationId, List<UUID> vehicleIds) {

        Optional<List<StationResevJpaEnt>> list =
                stationReservationJpaRepo.findByStationIdAndVehicleIdIn(stationId, vehicleIds);

        return list.map(stationInfraMpr::stationResevJpaEnt_to_stationResev)
                   .orElseThrow(() -> new StationResevInfraExc("error mapper StationResevJpaEnt to StationReserv"));

    }


    @Override
    public StationReservEnt save_stationReservEnt(StationReservEnt stationReservEnt) {

        StationResevJpaEnt entity = stationInfraMpr.stationReservEnt_to_customerEntity(stationReservEnt);
        stationReservationJpaRepo.save(entity);
        return stationReservEnt;
    }

    @Override
    public void delete_stationReservEnt(UUID reservationId) {

        Optional<StationResevJpaEnt> find = Optional.of(stationReservationJpaRepo.findByStationId(reservationId)
                                                                                 .orElseThrow(() -> new StationResevInfraExc(
                                                                                         "Exception thrown when finding for an id to update")));
        stationReservationJpaRepo.deleteById(find.get().getId());
    }

    @Override
    public StationReservEnt update_by_reservationId(UUID reservationId, StationReservEnt stationReservEnt) {

        Optional<StationResevJpaEnt> find = Optional.of(stationReservationJpaRepo.findByStationId(reservationId)
                                                                                 .orElseThrow(() -> new StationResevInfraExc(
                                                                                         "Exception thrown when finding for an id to update")));

        StationResevJpaEnt entity = stationInfraMpr.stationReservEnt_to_customerEntity(stationReservEnt);
        entity.setId(find.get().getId());
        stationReservationJpaRepo.save(entity);
        return stationReservEnt;
    }

}
