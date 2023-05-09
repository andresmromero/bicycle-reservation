package com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class DeleteByIdCustomer {

    private final CustomerSvc customerService;

    public void delete_by_id(CustomerId customerId) {

        customerService.delete_by_id(customerId);
    }

}
