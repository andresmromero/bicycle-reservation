package com.andresmromero.br.bo.customer.application.context.customer.service.command.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.application.context.customer.mapper.CustomerAppMpr;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class CreateCustomerHdl {

    private final CreateCustomer create;
    private final CustomerAppMpr customerMapper;

    @Transactional
    public void invoke(CreateCustomerCmd command) {

        CustomerAgg model = customerMapper.createCustomerCmd_to_customer(command);
        create.create(model);
    }

}
