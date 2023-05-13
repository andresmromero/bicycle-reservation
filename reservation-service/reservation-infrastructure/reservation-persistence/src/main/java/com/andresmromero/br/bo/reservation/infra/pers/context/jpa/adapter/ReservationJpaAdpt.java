package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.ReservationResvPersSvc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.ReservationJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper.ResvInfraJpaMpr;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository.ReservationJpaRepo;
import lombok.AllArgsConstructor;

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

}
