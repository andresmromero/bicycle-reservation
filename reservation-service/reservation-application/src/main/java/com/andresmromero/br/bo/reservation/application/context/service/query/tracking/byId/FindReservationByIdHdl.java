package com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.mapper.ReservationAppMrp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class FindReservationByIdHdl {

    private final FindReservationById findReservationById;
    private final ReservationAppMrp reservationAppMrp;

    public FindReservationByIdQryRes handle(FindReservationByIdQry query) {

        TrackingId trackingId = new TrackingId(query.trackingId());
        ReservationAgg model = findReservationById.invoke(trackingId);
        return reservationAppMrp.reservation_to_findReservationByIdQryRes(model);
    }

}
