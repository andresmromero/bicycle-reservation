package com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.repository;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureRepo;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.entity.CustomerJpaEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@InfrastructureRepo
public interface CustomerJpaRepo extends JpaRepository<CustomerJpaEnt, UUID> {}
