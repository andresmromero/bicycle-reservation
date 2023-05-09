package com.andresmromero.br.bo.customer.application.context.customer.service.command;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.create.CreateCustomerCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.create.CreateCustomerHdl;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId.DeleteCustomerByIdCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId.DeleteCustomerByIdHdl;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId.UpdateCustomerByIdCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId.UpdateCustomerByIdHdl;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class CustomerCmdAdpt implements CustomerCmdSvc {

    private final CreateCustomerHdl createCustomerHdl;
    private final UpdateCustomerByIdHdl updateCustomerHdl;
    private final DeleteCustomerByIdHdl deleteByIdCustomerHdl;

    @Override
    public void save_customer(CreateCustomerCmd command) {

        createCustomerHdl.invoke(command);
    }

    @Override
    public void update_customer_by_id(UpdateCustomerByIdCmd command) {

        updateCustomerHdl.invoke(command);
    }

    @Override
    public void delete_customer_by_id(DeleteCustomerByIdCmd command) {

        deleteByIdCustomerHdl.invoke(command);
    }

}
