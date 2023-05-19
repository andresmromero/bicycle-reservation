package com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record GetAvailableMainQryResp(


        UUID stationId,

        UUID vehicleId,

        String stationName,

        Boolean vehicleIsActive,

        String vehicleName,

        BigDecimal vehiclePrice, Boolean stationActive,

        Boolean vehicleAvailable, UUID vehicleBrand, UUID vehicleModel


) {}
