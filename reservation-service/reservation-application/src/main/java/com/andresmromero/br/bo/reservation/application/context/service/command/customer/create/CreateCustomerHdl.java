package com.andresmromero.br.bo.reservation.application.context.service.command.customer.create;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.mapper.ReservationAppMrp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class CreateCustomerHdl {

    private final CreateCustomer create;
    private final ReservationAppMrp reservationAppMrp;

    @Transactional
    public void invoke(CreateCustomerCmd command) {

        CustomerResvAgg model = reservationAppMrp.createCustomerCmd_to_customer(command);
        create.create(model);
    }

}
