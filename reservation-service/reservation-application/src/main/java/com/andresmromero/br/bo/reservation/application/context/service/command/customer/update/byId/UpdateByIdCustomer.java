package com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class UpdateByIdCustomer {

    private final CustomerResvPersSvc customerResvPersSvc;

    public void update_by_id(CustomerResvAgg adapted) {

        customerResvPersSvc.update_by_id(adapted);
    }

}
