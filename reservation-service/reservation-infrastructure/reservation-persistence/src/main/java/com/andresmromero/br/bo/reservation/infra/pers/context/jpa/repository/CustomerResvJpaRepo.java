package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureRepo;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.CustomerResvJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@InfrastructureRepo
public interface CustomerResvJpaRepo extends JpaRepository<CustomerResvJpaEnt, UUID> {}
