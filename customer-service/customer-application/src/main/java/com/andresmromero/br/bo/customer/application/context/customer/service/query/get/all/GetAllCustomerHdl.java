package com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.application.context.customer.mapper.CustomerAppMpr;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class GetAllCustomerHdl {

    private final GetAllCustomer getAllCustomer;
    private final CustomerAppMpr customerMapper;

    @Transactional
    public GetAllCustomersQryResponse invoke() {

        List<CustomerAgg> customerList = getAllCustomer.get_all();
        return customerMapper.customer_to_getAllCustomerQryResponse(customerList);
    }

}
