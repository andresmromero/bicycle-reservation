package com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.exception.ResvAppExc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.adapter.ReservationJpaAdpt;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class FindReservationById {

    private final ReservationJpaAdpt reservationJpaAdpt;

    public ReservationAgg invoke(TrackingId trackingId) {

        return reservationJpaAdpt.get_by_tracking_id(trackingId).orElseThrow(

                () -> new ResvAppExc("Reservation - tracking id no found"));

    }

}
