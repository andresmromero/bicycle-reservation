package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;

import java.util.Optional;

public interface CustomerResvPersSvc {
    Optional<CustomerResvAgg> get_customer_id(CustomerId customerId);

}
