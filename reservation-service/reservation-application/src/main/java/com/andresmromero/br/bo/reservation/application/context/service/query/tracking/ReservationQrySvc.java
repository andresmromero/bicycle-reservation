package com.andresmromero.br.bo.reservation.application.context.service.query.tracking;

import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQryRes;

public interface ReservationQrySvc {

    FindReservationByIdQryRes find_by_id_tracking(FindReservationByIdQry findReservationByIdQry);

}
