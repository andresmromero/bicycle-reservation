package com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.application.context.customer.mapper.CustomerAppMpr;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class GetCustomerByIdHdl {

    private final GetByIdCustomer getByIdCustomer;
    private final CustomerAppMpr customerMapper;

    @Transactional
    public GetCustomerByIdQryResp invoke(GetCustomerByIdQry query) {

        CustomerId customerId = new CustomerId(query.id());
        CustomerAgg customer = getByIdCustomer.getById(customerId);
        return customerMapper.customer_to_getByIdCustomerQryResp(customer);

    }

}
