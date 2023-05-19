package com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm;


import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;


public record GetAvailableComm(

        @NotNull UUID StationId, @NotNull List<UUID> vehicleIds

) {

    public GetAvailableComm {

    }

}
