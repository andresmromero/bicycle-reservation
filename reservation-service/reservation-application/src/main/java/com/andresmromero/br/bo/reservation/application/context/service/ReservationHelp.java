package com.andresmromero.br.bo.reservation.application.context.service;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.exception.ResvAppExc;
import com.andresmromero.br.bo.reservation.application.context.mapper.ReservationAppMrp;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.ReservationResvPersSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.StationResvPersSvc;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class ReservationHelp {

    private final CustomerResvPersSvc customerResvPersSvc;
    private final StationResvPersSvc stationResvPersSvc;
    private final ReservationResvPersSvc reservationResvPersSvc;

    private final ReservationAppMrp reservationAppMrp;

    public void customer_exist(CustomerId customerId) {

        customerResvPersSvc.get_customer_id(customerId).orElseThrow(() -> new ResvAppExc("Customer no found"));

    }

    public StationResvAgg get_listStationVehicles(CreateReservationCmd createReservationCmd) {

        StationResvAgg stationListVehiclesOnly =
                reservationAppMrp.createReservationCmd_listVehicle(createReservationCmd);

        return stationResvPersSvc.get_station(stationListVehiclesOnly)
                                 .orElseThrow(() -> new ResvAppExc("Station no found"));

    }

    public void save_reservation(ReservationAgg reservation) {

        ReservationAgg save = reservationResvPersSvc.save_reservation(reservation);
        if (save == null) {
            throw new ResvAppExc("Reservation not saved");
        }

    }

}
