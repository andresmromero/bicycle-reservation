package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import lombok.AllArgsConstructor;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class GetAllCustomer {

    private final CustomerResvPersSvc customerResvPersSvc;

    public List<CustomerResvAgg> get_all() {

        return customerResvPersSvc.get_all_customer();

    }

}
