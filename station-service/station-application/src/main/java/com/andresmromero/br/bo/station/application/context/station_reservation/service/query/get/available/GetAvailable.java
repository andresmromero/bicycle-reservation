package com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.application.context.station_reservation.mapper.StationReservationAppMpr;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp.GetAvailableMainQryResp;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp.GetAvailableQryResp;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.persistence.StationPersSvc;
import lombok.AllArgsConstructor;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class GetAvailable {

    private final StationPersSvc stationPersSvc;
    private final StationReservationAppMpr stationReservationAppMpr;

    public GetAvailableQryResp invoke(GetAvailableQry query) {

        List<StationReservEnt> res =
                stationPersSvc.pers_find_By_StationId_VehicleId_In(query.StationId(), query.vehicleIds());

        List<GetAvailableMainQryResp> mainList =
                stationReservationAppMpr.list_stationReserv_to_getAvailableMainQryResp(res);
        return GetAvailableQryResp.builder().items(mainList).build();
    }

}
