package com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available;


import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;


public record GetAvailableQry(

        @NotNull UUID StationId, @NotNull List<UUID> vehicleIds

) {}
