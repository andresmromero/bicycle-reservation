package com.andresmromero.br.bo.reservation.domain.context.reservation.service;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.VehicleResv;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import org.springframework.stereotype.Component;

@Component
public class ReservationDomHelp {

    public void set_reservation_vehicle(ReservationAgg reservation, StationResvAgg station) {

        reservation.getItems().forEach(x -> station.getVehicles().forEach(vehicleListItem -> {
            VehicleResv vehicle = x.getVehicle();
            if (vehicle.equals(vehicleListItem)) {
                vehicle.update_name_price(vehicleListItem.getName(), vehicleListItem.getPrice());
            }
        }));

    }

}
