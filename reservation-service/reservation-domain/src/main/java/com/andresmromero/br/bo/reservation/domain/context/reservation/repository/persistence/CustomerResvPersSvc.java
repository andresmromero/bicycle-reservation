package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;

import java.util.List;
import java.util.Optional;

public interface CustomerResvPersSvc {

    Optional<CustomerResvAgg> get_customer_id(CustomerId customerId);

    CustomerResvAgg save(CustomerResvAgg customer);

    void delete_by_id(CustomerId customerId);

    CustomerResvAgg update_by_id(CustomerResvAgg customer);

    List<CustomerResvAgg> get_all_customer();

    Optional<CustomerResvAgg> get_customer_by_id(CustomerId customerId);

}
