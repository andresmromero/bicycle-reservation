package com.andresmromero.br.bo.reservation.application.context.service.query;

import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.GetCustomerByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQryRes;

public interface ReservationQrySvc {

    FindReservationByIdQryRes find_by_id_tracking(FindReservationByIdQry findReservationByIdQry);

    GetAllCustomersQryResponse get_all_customers();

    GetCustomerByIdQryResp get_customer_by_id(GetCustomerByIdQry query);

}
