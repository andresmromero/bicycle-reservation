package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureRepo;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.StationResvJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@InfrastructureRepo
public interface StationResvJpaRepo extends JpaRepository<StationResvJpaEnt, UUID> {

    Optional<List<StationResvJpaEnt>> findByStationIdAndVehicleIdIn(UUID stationId, List<UUID> vehicleIds);

}
