package com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm;

import lombok.Builder;

import java.util.List;

@Builder
public record GetAvailableQryComm(

        List<GetAvailableMainQryComm> items) {

    public GetAvailableQryComm {

    }

}
