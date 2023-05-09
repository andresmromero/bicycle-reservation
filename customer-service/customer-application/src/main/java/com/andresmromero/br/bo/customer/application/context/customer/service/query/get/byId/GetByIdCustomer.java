package com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.application.context.customer.exception.CustomerAppExc;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class GetByIdCustomer {

    private final CustomerSvc customerService;

    public CustomerAgg getById(CustomerId customerId) {

        return customerService.get_customer_by_id(customerId)
                              .orElseThrow(() -> new CustomerAppExc("exception thrown when client id not found"));

    }

}
