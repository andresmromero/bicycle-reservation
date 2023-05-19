package com.andresmromero.br.bo.customer.domain.context.customer.repository;

import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.CreateCustomerComm;
import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.UpdateResevCustomerByIdComm;

import java.util.UUID;

public interface CustResvCommSvc {

    void save_customer(CreateCustomerComm command);

    void update_customer_by_id(UUID id, UpdateResevCustomerByIdComm command);

    void delete_customer_by_id(UUID id);

}
