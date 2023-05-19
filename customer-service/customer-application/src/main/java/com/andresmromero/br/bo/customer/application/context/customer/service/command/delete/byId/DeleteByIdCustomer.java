package com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import com.andresmromero.br.bo.customer.infrastructure.comm.context.http.CustReservHttpRest;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class DeleteByIdCustomer {

    private final CustomerSvc customerService;
    private final CustReservHttpRest custReservHttpRest;

    public void delete_by_id(CustomerId customerId) {

        customerService.delete_by_id(customerId);
        custReservHttpRest.delete_customer_by_id(customerId.getValue());

    }

}
