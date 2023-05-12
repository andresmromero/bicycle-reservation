package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;

import java.util.Optional;

public interface ReservationPersService {

    ReservationAgg save(ReservationAgg reservationAgg);

    Optional<ReservationAgg> findById(ReservationId reservationId);

}
