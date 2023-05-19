package com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp;

import lombok.Builder;

import java.util.List;

@Builder
public record GetAvailableQryResp(

        List<GetAvailableMainQryResp> items


) {}
