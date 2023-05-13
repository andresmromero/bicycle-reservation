package com.andresmromero.br.bo.reservation.domain.context.reservation.service.response;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;

import java.util.List;

public class ReservationCreatedDomRes extends ReservationDomRes {

    public ReservationCreatedDomRes(ReservationAgg reservation, List<String> messageBox) {

        super(reservation, messageBox);
    }

}
