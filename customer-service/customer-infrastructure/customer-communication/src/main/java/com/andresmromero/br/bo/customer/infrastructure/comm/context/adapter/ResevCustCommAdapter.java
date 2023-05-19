package com.andresmromero.br.bo.customer.infrastructure.comm.context.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustResvCommSvc;
import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.CreateCustomerComm;
import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.UpdateResevCustomerByIdComm;
import com.andresmromero.br.bo.customer.infrastructure.comm.context.http.CustReservHttpRest;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@InfrastructureSvc
public class ResevCustCommAdapter implements CustResvCommSvc {

    private final CustReservHttpRest custReservHttpRest;

    @Override
    public void save_customer(CreateCustomerComm command) {

        custReservHttpRest.save_customer(command);
    }

    @Override
    public void update_customer_by_id(UUID id, UpdateResevCustomerByIdComm command) {

        custReservHttpRest.update_customer_by_id(id, command);
    }

    @Override
    public void delete_customer_by_id(UUID id) {

        custReservHttpRest.delete_customer_by_id(id);
    }

}
