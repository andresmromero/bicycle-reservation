package com.andresmromero.br.bo.customer.application.context.customer.service.command.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.CreateCustomerComm;
import com.andresmromero.br.bo.customer.infrastructure.comm.context.http.CustReservHttpRest;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class CreateCustomer {

    private final CustReservHttpRest custReservHttpRest;
    private final CustomerSvc customerService;

    public void create(CustomerAgg adapted) {

        customerService.save(adapted);

        String nick = adapted.getName().getValue() + "nk";


        CreateCustomerComm updateChildren = CreateCustomerComm.builder()
                                                              .id(adapted.getId().getValue())
                                                              .email(adapted.getEmail().getValue())
                                                              .name(adapted.getName().getValue())
                                                              .surname(adapted.getSurname().getValue())
                                                              .nickname(nick)
                                                              .build();

        custReservHttpRest.save_customer(updateChildren);

    }

}
