package com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class UpdateByIdCustomer {

    private final CustomerSvc customerService;

    public void update_by_id(CustomerAgg adapted) {

        customerService.update_by_id(adapted);
    }

}
