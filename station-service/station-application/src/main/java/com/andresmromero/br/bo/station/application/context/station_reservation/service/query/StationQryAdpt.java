package com.andresmromero.br.bo.station.application.context.station_reservation.service.query;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.GetAvailableHdl;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.GetAvailableQry;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp.GetAvailableQryResp;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class StationQryAdpt implements StationQrySvc {

    private final GetAvailableHdl getAvailableHdl;


    @Override
    public GetAvailableQryResp get_ent_stationReservation(GetAvailableQry query) {

        return getAvailableHdl.handle(query);
    }

}
