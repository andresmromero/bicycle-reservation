package com.andresmromero.br.bo.station.domain.context.station_reservation.service;

import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.response.StationDom;

import java.util.List;

public interface StationDomSvc {

    StationDom valid_reservation(StationAgg station, List<String> messageBox);

}
