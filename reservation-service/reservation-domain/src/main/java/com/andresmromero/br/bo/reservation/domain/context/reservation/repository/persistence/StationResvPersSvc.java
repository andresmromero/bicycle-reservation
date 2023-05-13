package com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence;

import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;

import java.util.Optional;

public interface StationResvPersSvc {

    Optional<StationResvAgg> get_station(StationResvAgg station);

}
