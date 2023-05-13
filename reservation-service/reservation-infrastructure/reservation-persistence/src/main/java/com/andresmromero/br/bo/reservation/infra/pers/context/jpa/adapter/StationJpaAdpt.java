package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.StationResvPersSvc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper.ResvInfraJpaMpr;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository.StationResvJpaRepo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@InfrastructureSvc
public class StationJpaAdpt implements StationResvPersSvc {

    private final StationResvJpaRepo stationResvJpaRepo;
    private final ResvInfraJpaMpr resvInfraJpaMpr;


    @Override
    public Optional<StationResvAgg> get_station(StationResvAgg station) {

        UUID id = station.getId().getValue();
        List<UUID> vehicleIdList = resvInfraJpaMpr.station_extract_stationVehicle(station);

        return stationResvJpaRepo.findByStationIdAndVehicleIdIn(id, vehicleIdList)
                                 .map(resvInfraJpaMpr::stationEntity_to_station);
    }

}
