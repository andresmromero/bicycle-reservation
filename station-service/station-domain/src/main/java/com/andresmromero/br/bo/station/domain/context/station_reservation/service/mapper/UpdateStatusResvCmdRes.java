package com.andresmromero.br.bo.station.domain.context.station_reservation.service.mapper;

import java.util.List;

public class UpdateStatusResvCmdRes {

    private List<String> message;

    public UpdateStatusResvCmdRes() {

    }

    public UpdateStatusResvCmdRes(List<String> message) {

        this.message = message;
    }

    public List<String> getMessage() {

        return message;
    }

    public void setMessage(List<String> message) {

        this.message = message;
    }

}
