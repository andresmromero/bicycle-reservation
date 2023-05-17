package com.andresmromero.br.bo.reservation.application.context.service.query;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.GetAllCustomerHdl;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.GetCustomerByIdHdl;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.GetCustomerByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdHdl;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQryRes;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationSvc
@AllArgsConstructor
public class ReservationQryAdpt implements ReservationQrySvc {

    private final FindReservationByIdHdl findReservationByIdHdl;
    private final GetAllCustomerHdl getAllCustomerHdl;
    private final GetCustomerByIdHdl getCustomerByIdHdl;

    @Override
    @Transactional(readOnly = true)
    public FindReservationByIdQryRes find_by_id_tracking(FindReservationByIdQry findReservationByIdQry) {

        return findReservationByIdHdl.handle(findReservationByIdQry);
    }

    @Override
    public GetAllCustomersQryResponse get_all_customers() {

        return getAllCustomerHdl.invoke();
    }

    @Override
    public GetCustomerByIdQryResp get_customer_by_id(GetCustomerByIdQry query) {

        return getCustomerByIdHdl.invoke(query);
    }

}
