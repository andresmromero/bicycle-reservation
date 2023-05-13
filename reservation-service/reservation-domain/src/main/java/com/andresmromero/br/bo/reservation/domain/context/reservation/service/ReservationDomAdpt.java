package com.andresmromero.br.bo.reservation.domain.context.reservation.service;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.response.ReservationCreatedDomRes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ReservationDomAdpt implements ReservationDomSvc {

    private ReservationDomHelp reservationDomHelp;

    @Override
    public ReservationCreatedDomRes initReservation(ReservationAgg reservation, StationResvAgg station) {

        List<String> messageBox = new ArrayList<>();

        station.val_init(station, messageBox);
        reservationDomHelp.set_reservation_vehicle(reservation, station);
        reservation.val_init_reservation(messageBox);
        reservation.val_total_price(messageBox);
        reservation.val_items_price(messageBox);

        if (messageBox.isEmpty()) {

            reservation.init_reservation(reservation);
        }
        reservation.setMessageBox(messageBox);
        return new ReservationCreatedDomRes(reservation, messageBox);

    }

}
