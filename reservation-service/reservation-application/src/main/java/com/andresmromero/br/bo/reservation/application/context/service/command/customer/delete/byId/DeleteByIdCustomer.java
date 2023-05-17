package com.andresmromero.br.bo.reservation.application.context.service.command.customer.delete.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class DeleteByIdCustomer {

    private final CustomerResvPersSvc customerResvPersSvc;

    public void delete_by_id(CustomerId customerId) {

        customerResvPersSvc.delete_by_id(customerId);
    }

}
