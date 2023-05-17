package com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.mapper.ReservationAppMrp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class UpdateCustomerByIdHdl {

    private final UpdateByIdCustomer update;
    private final ReservationAppMrp reservationAppMrp;

    @Transactional
    public void invoke(UpdateResevCustomerByIdCmd command) {

        CustomerResvAgg model = reservationAppMrp.updateCustomerCmd_to_customer(command);
        update.update_by_id(model);
    }

}
