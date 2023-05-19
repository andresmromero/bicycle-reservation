package com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm;

import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record GetAvailableMainQryComm(UUID stationId,

                                      UUID vehicleId,

                                      String stationName,

                                      Boolean vehicleIsActive,

                                      String vehicleName,

                                      BigDecimal vehiclePrice, Boolean stationActive,

                                      Boolean vehicleAvailable, UUID vehicleBrand, UUID vehicleModel

) {

    public GetAvailableMainQryComm {

    }

}
