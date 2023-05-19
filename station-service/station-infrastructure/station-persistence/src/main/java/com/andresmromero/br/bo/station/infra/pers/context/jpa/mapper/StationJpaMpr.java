package com.andresmromero.br.bo.station.infra.pers.context.jpa.mapper;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.BrandId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ModelId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.VehicleId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureComp;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationDetailStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationReceivedStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.VehicleStn;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.exception.StationResevInfraExc;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity.ResevReceiveJpaEnt;
import com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity.StationResevJpaEnt;

import java.util.List;
import java.util.UUID;

@InfrastructureComp
public class StationJpaMpr {

    public ResevReceiveJpaEnt reservationReceive_to_reservationReceiveEntity(ReservationReceivedStn rr) {

        return ResevReceiveJpaEnt.builder()
                                 .id(rr.getId().getValue())
                                 .stationId(rr.getStationId().getValue())
                                 .reservationId(rr.getReservationId().getValue())
                                 .status(rr.getStatus())
                                 .build();
    }

    public List<UUID> station_to_stationVehicles(StationAgg station) {

        return station.getReservationDetail().getVehicleList().stream().map(v -> v.getId().getValue()).toList();
    }

    public StationAgg stationReservationEntity_to_StationReservation(List<StationResevJpaEnt> st) {


        StationResevJpaEnt stationEntity =
                st.stream().findFirst().orElseThrow(() -> new StationResevInfraExc("Station no found"));

        List<VehicleStn> stationList = st.stream().map(e -> VehicleStn.Builder.builder()

                                                                              .id(new VehicleId(e.getVehicleId()))
                                                                              .brand(new BrandId(e.getVehicleBrand()))
                                                                              .model(new ModelId(e.getVehicleModel()))
                                                                              .name(e.getVehicleName())
                                                                              .price(new MoneyVo(e.getVehiclePrice()))
                                                                              .available(e.getVehicleAvailable())
                                                                              .build()).toList();

        return StationAgg.Builder.builder()
                                 .id(new StationId(stationEntity.getStationId()))
                                 .reservationDetail(ReservationDetailStn.Builder.builder()

                                                                                .vehicleList(stationList).build())
                                 .isActive(stationEntity.getVehicleIsActive())
                                 .build();

    }

    public List<StationReservEnt> stationResevJpaEnt_to_stationResev(List<StationResevJpaEnt> s) {

        return s.stream()
                .map(e -> new StationReservEnt(e.getStationId(),
                                               e.getVehicleId(),
                                               e.getStationName(),
                                               e.getVehicleIsActive(),
                                               e.getVehicleName(),
                                               e.getVehiclePrice(),
                                               e.getVehicleAvailable(),
                                               e.getVehicleBrand(),
                                               e.getVehicleModel(),
                                               e.getStationActive()))
                .toList();
    }


    public StationResevJpaEnt stationReservEnt_to_customerEntity(StationReservEnt s) {

        return StationResevJpaEnt.builder()
                                 .stationId(s.getStationId())
                                 .vehicleId(s.getVehicleId())
                                 .stationName(s.getStationName())
                                 .vehicleIsActive(s.getVehicleIsActive())
                                 .vehicleName(s.getVehicleName())
                                 .vehiclePrice(s.getVehiclePrice())
                                 .vehicleAvailable(s.getVehicleAvailable())
                                 .vehicleBrand(s.getVehicleBrand())
                                 .vehicleModel(s.getVehicleModel())
                                 .stationActive(s.getStationActive())
                                 .build();

    }

    public StationReservEnt stationResevJpaEnt_to_stationReservEnt(StationResevJpaEnt s) {

        return new StationReservEnt(s.getStationId(),
                                    s.getVehicleId(),
                                    s.getStationName(),
                                    s.getVehicleIsActive(),
                                    s.getVehicleName(),
                                    s.getVehiclePrice(),
                                    s.getVehicleAvailable(),
                                    s.getVehicleBrand(),
                                    s.getVehicleModel(),
                                    s.getStationActive()

        );
    }

}
