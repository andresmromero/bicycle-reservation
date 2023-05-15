package com.andresmromero.br.bo.station.domain.context.station_reservation.service.response;

import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;

import java.util.List;

public class StationDomRes extends StationDom {


    public StationDomRes(StationAgg station, List<String> messageBox) {

        super(station, messageBox);
    }

}
