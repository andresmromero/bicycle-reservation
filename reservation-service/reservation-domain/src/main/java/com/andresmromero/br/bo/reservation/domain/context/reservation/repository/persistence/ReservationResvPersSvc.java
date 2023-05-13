package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;

import java.util.Optional;

public interface ReservationResvPersSvc {

    ReservationAgg save_reservation(ReservationAgg reservationAgg);

    Optional<ReservationAgg> get_by_tracking_id(TrackingId trackingId);

}
