package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureRepo;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.ReservationJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

@InfrastructureRepo
public interface ReservationJpaRepo extends JpaRepository<ReservationJpaEnt, UUID> {

    Optional<ReservationJpaEnt> findByTrackingId(UUID trackingId);

}
