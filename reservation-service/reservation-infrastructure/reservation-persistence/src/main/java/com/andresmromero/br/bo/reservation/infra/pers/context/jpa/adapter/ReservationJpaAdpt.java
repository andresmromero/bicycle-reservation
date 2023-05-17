package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.adapter;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.ReservationResvPersSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.ReservationJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.exception.ResvInfraExc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper.ResvInfraJpaMpr;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository.ReservationJpaRepo;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.UUID;

@InfrastructureSvc
@AllArgsConstructor
public class ReservationJpaAdpt implements ReservationResvPersSvc {

    private final ReservationJpaRepo reservationJpaRepo;
    private final ResvInfraJpaMpr resvInfraJpaMpr;

    @Override
    public ReservationAgg save_reservation(ReservationAgg reservationAgg) {

        ReservationJpaEnt toEntity = resvInfraJpaMpr.reservation_to_reservationEntity(reservationAgg);
        reservationJpaRepo.save(toEntity);
        return reservationAgg;
    }

    @Override
    public Optional<ReservationAgg> get_by_tracking_id(TrackingId trackingId) {

        UUID id = trackingId.getValue();
        return Optional.of(reservationJpaRepo.findByTrackingId(id)
                                             .map(resvInfraJpaMpr::reservationEntity_to_reservation)
                                             .orElseThrow(() -> new ResvInfraExc("Error when finding for tracking id")));

    }

    @Override
    public Optional<ReservationAgg> get_reservation(ReservationId reservationId) {

        UUID id = reservationId.getValue();
        return Optional.of(reservationJpaRepo.findByReservationId(id)
                                             .map(resvInfraJpaMpr::reservationEntity_to_reservation)
                                             .orElseThrow(() -> new ResvInfraExc("Error finding reservation")));

    }

    @Override
    public Optional<ReservationAgg> update_status_reservation(ReservationAgg reservation) {


        return Optional.empty();
    }

}
