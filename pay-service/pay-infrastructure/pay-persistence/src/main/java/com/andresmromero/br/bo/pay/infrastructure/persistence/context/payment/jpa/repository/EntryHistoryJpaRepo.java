package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.repository;

import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.EntryHistoryJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntryHistoryJpaRepo extends JpaRepository<EntryHistoryJpaEnt, UUID> {

    Optional<List<EntryHistoryJpaEnt>> findByCustomerId(UUID customerId);

}
