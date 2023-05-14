package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.repository;

import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.PaymentJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PaymentJpaRepo extends JpaRepository<PaymentJpaEnt, UUID> {

    Optional<PaymentJpaEnt> findByReservationId(UUID reservationId);

}
