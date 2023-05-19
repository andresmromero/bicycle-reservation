package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.comm.ReservationCommService;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.StationResvPersSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableComm;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableMainQryComm;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper.ResvInfraJpaMpr;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@InfrastructureSvc
public class StationJpaAdpt implements StationResvPersSvc {

    private final ResvInfraJpaMpr resvInfraJpaMpr;

    private final ReservationCommService reservationCommService;

    @Override
    public Optional<StationResvAgg> get_station(StationResvAgg station) {

        UUID id = station.getId().getValue();
        List<UUID> vehicleIdList = resvInfraJpaMpr.station_extract_stationVehicle(station);

        Optional<List<GetAvailableMainQryComm>> stationInfo =
                Optional.of(reservationCommService.get_station(new GetAvailableComm(id, vehicleIdList)).items());

        return stationInfo.map(resvInfraJpaMpr::getAvailableMainQryComm_to_station);

    }

}
