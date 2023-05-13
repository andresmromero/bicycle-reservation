package com.andresmromero.br.bo.reservation.domain.context.reservation.service;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.response.ReservationCreatedDomRes;

public interface ReservationDomSvc {

    ReservationCreatedDomRes initReservation(ReservationAgg reservation, StationResvAgg station);

}
