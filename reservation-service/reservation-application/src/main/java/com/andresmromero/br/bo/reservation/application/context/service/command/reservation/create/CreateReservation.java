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

        persistenceReservations(reservationCreatedDomRes);

        CreateReservationCmdRes response =
                reservationAppMrp.reservation_to_createReservationCmdRes(reservationCreatedDomRes.getReservation());
        return response;
    }

    private void persistenceReservations(ReservationCreatedDomRes reservationCreatedDomRes) {

        reservationHelp.save_reservation(reservationCreatedDomRes.getReservation());
    }

}
