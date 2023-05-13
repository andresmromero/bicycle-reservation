package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.adapter;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.exception.ResvInfraExc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper.ResvInfraJpaMpr;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository.CustomerResvJpaRepo;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@InfrastructureSvc
@AllArgsConstructor
public class CustomerJpaAdpt implements CustomerResvPersSvc {

    private final CustomerResvJpaRepo customerJpaRepo;
    private final ResvInfraJpaMpr infraJpaMpr;

    @Override
    public Optional<CustomerResvAgg> get_customer_id(CustomerId customerId) {

        UUID id = customerId.getValue();
        return Optional.of(customerJpaRepo.findById(id)
                                          .map(infraJpaMpr::customerEntity_to_customer)
                                          .orElseThrow(() -> new ResvInfraExc("Error when finding for customer id")));
    }

}
