package com.andresmromero.br.bo.station.application.context.station_reservation.mapper;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.VehicleId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.application.context.station_reservation.exception.StationReservationAppExc;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.create.CreateStatResevCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId.UpdStatResevIdCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp.GetAvailableMainQryResp;
import com.andresmromero.br.bo.station.domain.context.station_reservation.entity.StationReservEnt;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.ReservationDetailStn;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.VehicleStn;

import java.util.List;
import java.util.UUID;

@ApplicationComp
public class StationReservationAppMpr {


    public static StationAgg receiveReservationCmd_to_station(ReceiveReservationCmd c) {


        return StationAgg.Builder.builder()

                                 .id(new StationId(UUID.fromString(c.stationId())))

                                 .reservationDetail(

                                         ReservationDetailStn.Builder.builder()

                                                                     .reservationId(new ReservationId(UUID.fromString(c.reservationId())))


                                                                     .vehicleList(

                                                                             c.vehicles()
                                                                              .stream()
                                                                              .map(veh -> VehicleStn.Builder.builder()
                                                                                                            .id(new VehicleId(
                                                                                                                    veh.vehicleId()))
                                                                                                            .quantity(
                                                                                                                    veh.quantity())
                                                                                                            .build()

                                                                                  )
                                                                              .toList())
                                                                     .total(new MoneyVo(c.price()))

                                                                     .status(get_reservation_status(c.status()))
                                                                     .build()).build();

    }

    private static ReservationStatus get_reservation_status(String status) {

        String st = status.toUpperCase();
        if (st.equals(ReservationStatus.PENDING.name())) {
            return ReservationStatus.PENDING;
        }
        if (st.equals(ReservationStatus.PAID.name())) {
            return ReservationStatus.PAID;
        }
        if (st.equals(ReservationStatus.APPROVED.name())) {
            return ReservationStatus.APPROVED;
        }
        if (st.equals(ReservationStatus.CANCELLED.name())) {
            return ReservationStatus.CANCELLED;
        }
        if (st.equals(ReservationStatus.CANCELLING.name())) {
            return ReservationStatus.CANCELLING;
        }
        throw new StationReservationAppExc("Reservation status no found");
    }

    public StationReservEnt createStatResevCmd_to_stationReservEnt(CreateStatResevCmd c) {

        return new StationReservEnt(c.stationId(),
                                    c.vehicleId(),
                                    c.stationName(),
                                    c.vehicleIsActive(),
                                    c.vehicleName(),
                                    c.vehiclePrice(),
                                    c.vehicleAvailable(),
                                    c.vehicleBrand(),
                                    c.vehicleModel(),
                                    c.stationActive());

    }

    public List<GetAvailableMainQryResp> list_stationReserv_to_getAvailableMainQryResp(List<StationReservEnt> m) {

        return m.stream()
                .map(x -> GetAvailableMainQryResp.builder()
                                                 .stationId(x.getStationId())
                                                 .vehicleId(x.getVehicleId())
                                                 .stationName(x.getStationName())
                                                 .vehicleIsActive(x.getVehicleIsActive())
                                                 .vehicleName(x.getVehicleName())
                                                 .vehiclePrice(x.getVehiclePrice())
                                                 .vehicleAvailable(x.getVehicleAvailable())
                                                 .vehicleBrand(x.getVehicleBrand())
                                                 .vehicleModel(x.getVehicleModel())
                                                 .stationActive(x.getStationActive())
                                                 .build())

                .toList();

    }

    public StationReservEnt updateStatResevByIdCmd_to_stationReservEnt(UpdStatResevIdCmd c) {

        return new StationReservEnt(c.stationId(),
                                    c.vehicleId(),
                                    c.stationName(),
                                    c.vehicleIsActive(),
                                    c.vehicleName(),
                                    c.vehiclePrice(),
                                    c.vehicleAvailable(),
                                    c.vehicleBrand(),
                                    c.vehicleModel(),
                                    c.stationActive());
    }

}
