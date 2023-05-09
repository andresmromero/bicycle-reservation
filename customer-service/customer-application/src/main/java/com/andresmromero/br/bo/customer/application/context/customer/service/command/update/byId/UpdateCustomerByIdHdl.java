package com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.application.context.customer.mapper.CustomerAppMpr;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class UpdateCustomerByIdHdl {

    private final UpdateByIdCustomer update;
    private final CustomerAppMpr customerMapper;

    @Transactional
    public void invoke(UpdateCustomerByIdCmd command) {

        CustomerAgg model = customerMapper.updateCustomerCmd_to_customer(command);
        update.update_by_id(model);
    }

}
