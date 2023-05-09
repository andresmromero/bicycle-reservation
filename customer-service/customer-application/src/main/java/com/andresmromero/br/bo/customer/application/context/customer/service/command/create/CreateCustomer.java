package com.andresmromero.br.bo.customer.application.context.customer.service.command.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class CreateCustomer {

    private final CustomerSvc customerService;

    public void create(CustomerAgg adapted) {

        CustomerAgg ww = customerService.save(adapted);
        System.out.println("=====xx");
        System.out.println(ww.getName().getValue());
    }

}
