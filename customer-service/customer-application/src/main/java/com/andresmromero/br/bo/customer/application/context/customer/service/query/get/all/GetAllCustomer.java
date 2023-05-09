package com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import lombok.AllArgsConstructor;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class GetAllCustomer {

    private final CustomerSvc customerService;

    public List<CustomerAgg> get_all() {

        return customerService.get_all_customer();

    }

}
