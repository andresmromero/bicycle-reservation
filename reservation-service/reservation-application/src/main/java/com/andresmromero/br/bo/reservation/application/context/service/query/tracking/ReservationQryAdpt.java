package com.andresmromero.br.bo.reservation.application.context.service.query.tracking;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdHdl;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQryRes;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationSvc
@AllArgsConstructor
public class ReservationQryAdpt implements ReservationQrySvc {

    private final FindReservationByIdHdl findReservationByIdHdl;

    @Override
    @Transactional(readOnly = true)
    public FindReservationByIdQryRes find_by_id_tracking(FindReservationByIdQry findReservationByIdQry) {

        return findReservationByIdHdl.handle(findReservationByIdQry);
    }

}
