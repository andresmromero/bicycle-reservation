package com.andresmromero.br.bo.station.domain.context.station_reservation.service.response;

import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;

import java.util.List;

public abstract class StationDom {

    private final StationAgg station;
    private final List<String> messageBox;

    public StationDom(StationAgg station, List<String> messageBox) {

        this.station = station;
        this.messageBox = messageBox;
    }

    public StationAgg getStation() {

        return station;
    }

    public List<String> getMessageBox() {

        return messageBox;
    }

}
