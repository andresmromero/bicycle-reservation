package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.repository;

import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.EntryJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EntryJpaRepo extends JpaRepository<EntryJpaEnt, UUID> {

    Optional<EntryJpaEnt> findByCustomerId(UUID customerId);

}
