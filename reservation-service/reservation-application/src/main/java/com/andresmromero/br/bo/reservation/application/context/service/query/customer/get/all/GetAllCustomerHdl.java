package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.mapper.ReservationAppMrp;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class GetAllCustomerHdl {

    private final GetAllCustomer getAllCustomer;
    private final ReservationAppMrp reservationAppMrp;

    @Transactional
    public GetAllCustomersQryResponse invoke() {

        List<CustomerResvAgg> customerList = getAllCustomer.get_all();
        return reservationAppMrp.customer_to_getAllCustomerQryResponse(customerList);
    }

}
