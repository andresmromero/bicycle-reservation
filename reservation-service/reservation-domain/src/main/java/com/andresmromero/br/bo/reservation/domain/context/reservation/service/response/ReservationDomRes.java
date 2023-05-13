package com.andresmromero.br.bo.reservation.domain.context.reservation.service.response;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;

import java.util.List;

public abstract class ReservationDomRes {

    private ReservationAgg reservation;
    private List<String> messageBox;

    public ReservationDomRes(ReservationAgg reservation, List<String> messageBox) {

        this.reservation = reservation;
        this.messageBox = messageBox;
    }

    public ReservationAgg getReservation() {

        return reservation;
    }

    public void setReservation(ReservationAgg reservation) {

        this.reservation = reservation;
    }

    public List<String> getMessageBox() {

        return messageBox;
    }

    public void setMessageBox(List<String> messageBox) {

        this.messageBox = messageBox;
    }

}
