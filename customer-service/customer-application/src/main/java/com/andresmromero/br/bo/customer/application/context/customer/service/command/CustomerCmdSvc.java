package com.andresmromero.br.bo.customer.application.context.customer.service.command;

import com.andresmromero.br.bo.customer.application.context.customer.service.command.create.CreateCustomerCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId.DeleteCustomerByIdCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId.UpdateCustomerByIdCmd;

public interface CustomerCmdSvc {

    void save_customer(CreateCustomerCmd command);

    void update_customer_by_id(UpdateCustomerByIdCmd command);

    void delete_customer_by_id(DeleteCustomerByIdCmd command);

}
