package com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.repository;

import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity.StationResevJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StationResevJpaRepo extends JpaRepository<StationResevJpaEnt, UUID> {

    Optional<List<StationResevJpaEnt>> findByStationIdAndVehicleIdIn(UUID stationId, List<UUID> vehicleIds);

}
