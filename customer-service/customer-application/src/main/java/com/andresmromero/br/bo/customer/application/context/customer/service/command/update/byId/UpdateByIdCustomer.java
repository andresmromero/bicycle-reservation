package com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.UpdateResevCustomerByIdComm;
import com.andresmromero.br.bo.customer.infrastructure.comm.context.http.CustReservHttpRest;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class UpdateByIdCustomer {

    private final CustomerSvc customerService;
    private final CustReservHttpRest custReservHttpRest;


    public void update_by_id(CustomerAgg adapted) {

        customerService.update_by_id(adapted);


        UpdateResevCustomerByIdComm updateChildren = UpdateResevCustomerByIdComm.builder()
                                                                                .email(adapted.getEmail().getValue())
                                                                                .name(adapted.getName().getValue())
                                                                                .surname(adapted.getSurname()
                                                                                                .getValue())
                                                                                .nickname(adapted.getName().getValue() +
                                                                                                  "nk")
                                                                                .build();


        custReservHttpRest.update_customer_by_id(adapted.getId().getValue(), updateChildren);
    }

}
