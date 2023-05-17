package com.andresmromero.br.bo.reservation.application.context.service.command.customer.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class CreateCustomer {

    private final CustomerResvPersSvc customerResvPersSvc;

    public void create(CustomerResvAgg adapted) {

        customerResvPersSvc.save(adapted);

    }

}
