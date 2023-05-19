package com.andresmromero.br.bo.station.application.context.station_reservation.service.query;

import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.GetAvailableQry;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp.GetAvailableQryResp;

public interface StationQrySvc {

    GetAvailableQryResp get_ent_stationReservation(GetAvailableQry query);

}
