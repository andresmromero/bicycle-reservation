package com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.mapper.ReservationAppMrp;
import com.andresmromero.br.bo.reservation.application.context.service.ReservationHelp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.ReservationDomSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.response.ReservationCreatedDomRes;
import lombok.AllArgsConstructor;

import java.util.HashMap;

@ApplicationComp
@AllArgsConstructor
public class CreateReservation {


    private final ReservationHelp reservationHelp;
    private final ReservationAppMrp reservationAppMrp;
    private final ReservationDomSvc reservationDomSvc;

    public CreateReservationCmdRes invoke(CreateReservationCmd command) {

        reservationHelp.customer_exist(new CustomerId(command.customerId()));

        StationResvAgg stationWithListStationVehicles = reservationHelp.get_listStationVehicles(command);

        ReservationAgg reservation = reservationAppMrp.createReservationCmd_to_reservation(command);

        ReservationCreatedDomRes reservationCreatedDomRes =
                reservationDomSvc.initReservation(reservation, stationWithListStationVehicles);
        HashMap<String, String> dataResponse = new HashMap<String, String>();
        if (reservationCreatedDomRes.getMessageBox().isEmpty()) {

            persistenceReservations(reservation);
            reservationCreatedDomRes.getMessageBox().add("Reservation created successfully");
            dataResponse.put("reservationId", reservation.getId().getValue().toString());
            dataResponse.put("trackingId", reservation.getTrackingId().getValue().toString());

        }


        return reservationAppMrp.reservation_to_createReservationCmdRes(reservationCreatedDomRes.getMessageBox(),
                                                                        dataResponse);

    }

    private void persistenceReservations(ReservationAgg reservation) {

        reservationHelp.save_reservation(reservation);
    }

}
