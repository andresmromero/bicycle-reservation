package com.andresmromero.br.bo.customer.domain.context.customer.repository;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;

import java.util.List;
import java.util.Optional;

public interface CustomerSvc {

    CustomerAgg save(CustomerAgg customer);

    void delete_by_id(CustomerId customerId);
    CustomerAgg update_by_id(CustomerAgg customer);

    List<CustomerAgg> get_all_customer();

    Optional<CustomerAgg> get_customer_by_id(CustomerId customerId);

}
