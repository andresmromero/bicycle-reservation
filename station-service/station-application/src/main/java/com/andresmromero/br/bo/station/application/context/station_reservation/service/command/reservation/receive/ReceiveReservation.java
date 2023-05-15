package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.application.context.station_reservation.mapper.StationReservationAppMpr;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.StationReservationHelper;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.StationDomSvc;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.response.StationDom;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationComp
@AllArgsConstructor
public class ReceiveReservation {

    public final StationReservationAppMpr stationReservationAppMpr;
    private final StationReservationHelper stationReservationHelper;
    private final StationDomSvc stationDomSvc;

    public ReceiveReservationRes invoke(ReceiveReservationCmd command) {

        List<String> messageBox = new ArrayList<>();
        StationAgg station = get_station(command);

        StationDom validReservationDomRes = stationDomSvc.valid_reservation(station, messageBox);


        stationReservationHelper.save_reservation_received(validReservationDomRes.getStation()
                                                                                 .getReservationReceived());

        return ReceiveReservationRes.builder().message(validReservationDomRes.getMessageBox()).build();
    }

    private StationAgg get_station(ReceiveReservationCmd command) {

        StationAgg station = StationReservationAppMpr.receiveReservationCmd_to_station(command);

        StationAgg stationResp = stationReservationHelper.get_station(station);

        StationAgg stationEntity = stationResp;
        station.setActive(stationEntity.isActive());
        station.getReservationDetail()
               .getVehicleList()
               .forEach(veh -> stationEntity.getReservationDetail().getVehicleList().forEach(v -> {
                   if (v.getId().equals(veh.getId())) {
                       veh.update_price_name_available(v.getName(), v.getPrice(), v.isAvailable());
                   }
               }));
        station.getReservationDetail().setId(new ReservationId(UUID.fromString(command.reservationId())));
        return station;

    }

}
