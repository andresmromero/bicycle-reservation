package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.mapper.ReservationAppMrp;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class GetCustomerByIdHdl {

    private final GetByIdCustomer getByIdCustomer;
    private final ReservationAppMrp reservationAppMrp;

    @Transactional
    public GetCustomerByIdQryResp invoke(GetCustomerByIdQry query) {

        CustomerId customerId = new CustomerId(query.id());
        CustomerResvAgg customer = getByIdCustomer.getById(customerId);
        return reservationAppMrp.customer_to_getByIdCustomerQryResp(customer);

    }

}
