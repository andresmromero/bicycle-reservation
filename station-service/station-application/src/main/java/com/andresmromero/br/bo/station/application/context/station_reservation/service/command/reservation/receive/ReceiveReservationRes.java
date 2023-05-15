package com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive;

import lombok.Builder;

import java.util.List;

@Builder
public record ReceiveReservationRes(List<String> message) {

}
