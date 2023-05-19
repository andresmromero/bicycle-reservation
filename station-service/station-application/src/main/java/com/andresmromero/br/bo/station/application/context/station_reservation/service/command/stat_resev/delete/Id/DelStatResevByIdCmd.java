package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.delete.Id;


import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.UUID;

@Builder
public record DelStatResevByIdCmd(@NotNull UUID id) {

    public DelStatResevByIdCmd(UUID id) {

        this.id = id;
    }

}
