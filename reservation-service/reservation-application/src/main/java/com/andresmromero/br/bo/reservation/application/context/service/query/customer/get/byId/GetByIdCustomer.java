package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.exception.ResvAppExc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class GetByIdCustomer {

    private final CustomerResvPersSvc customerResvPersSvc;

    public CustomerResvAgg getById(CustomerId customerId) {

        return customerResvPersSvc.get_customer_by_id(customerId)
                                  .orElseThrow(() -> new ResvAppExc("exception thrown when client id not found"));

    }

}
