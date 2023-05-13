package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;

public interface ReservationResvPersSvc {

    ReservationAgg save_reservation(ReservationAgg reservationAgg);

}
