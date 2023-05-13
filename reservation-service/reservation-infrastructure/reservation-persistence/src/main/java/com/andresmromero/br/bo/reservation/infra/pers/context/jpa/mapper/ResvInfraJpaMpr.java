package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.BrandId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ModelId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.VehicleId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.EmailVo;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureComp;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationItem;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.VehicleResv;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.ReservationJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.CustomerResvJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.StationResvJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.exception.ResvInfraExc;

import java.util.List;
import java.util.UUID;

@InfrastructureComp
public class ResvInfraJpaMpr {

    public CustomerResvJpaEnt customer_customerEntity(CustomerResvAgg c) {

        return CustomerResvJpaEnt.builder()
                                 .id(c.getId().getValue())
                                 .name(c.getName())
                                 .surname(c.getSurname())
                                 .email(c.getEmail().getValue())
                                 .build();
    }

    public CustomerResvAgg customerEntity_to_customer(CustomerResvJpaEnt c) {

        return CustomerResvAgg.Builder.builder()
                                      .name(c.getName())
                                      .surname(c.getSurname())
                                      .nickname(c.getNickname())
                                      .email(new EmailVo(c.getEmail()))
                                      .build();

    }


    public ReservationJpaEnt reservation_to_reservationEntity(ReservationAgg r) {

        return ReservationJpaEnt.builder()
                                .reservationId(r.getCustomerId().getValue())
                                .customerId(r.getCustomerId().getValue())
                                .stationId(r.getStationId().getValue())
                                .trackingId(r.getTrackingId().getValue())
                                .reservationStatus(r.getStatus().name())
                                .price(r.getPrice().getAmount())
                                .messagesBox(r.getMessageBox().toString())
                                .build();

    }


    public ReservationAgg reservationEntity_to_reservation(ReservationJpaEnt r) {

        return ReservationAgg.Builder.builder()
                                     .customerId(new CustomerId(r.getCustomerId()))
                                     .stationId(new StationId(r.getReservationId()))
                                     .price(new MoneyVo(r.getPrice()))
                                     .items(List.of(ReservationItem.Builder.builder().build()))
                                     .trackingId(new TrackingId(r.getTrackingId()))
                                     .status(get_reservation_status(r.getReservationStatus()))
                                     .messageBox(List.of(r.getMessagesBox()))
                                     .build();

    }

    private ReservationStatus get_reservation_status(String orderStatus) {

        if (orderStatus.equals(ReservationStatus.APPROVED.name())) {
            return ReservationStatus.APPROVED;
        }
        if (orderStatus.equals(ReservationStatus.PAID.name())) {
            return ReservationStatus.PAID;
        }
        if (orderStatus.equals(ReservationStatus.CANCELLED.name())) {
            return ReservationStatus.CANCELLED;
        }
        if (orderStatus.equals(ReservationStatus.PENDING.name())) {
            return ReservationStatus.PENDING;
        }
        if (orderStatus.equals(ReservationStatus.CANCELLING.name())) {
            return ReservationStatus.CANCELLING;
        }

        throw new ResvInfraExc("reservation status no found");
    }

    public List<UUID> station_extract_stationVehicle(StationResvAgg station) {

        return station.getVehicles().stream().map(x -> x.getId().getValue()).toList();
    }

    public StationResvAgg stationEntity_to_station(List<StationResvJpaEnt> stationList) {

        StationResvJpaEnt stationEntity =
                stationList.stream().findFirst().orElseThrow(() -> new ResvInfraExc("Station no found"));


        List<VehicleResv> stationVehicleList = stationList.stream()
                                                          .map(x -> VehicleResv.Builder.builder()
                                                                                       .vehicleId(new VehicleId(x.getVehicleId()))
                                                                                       .name(x.getVehicleName())
                                                                                       .price(new MoneyVo(x.getVehiclePrice()))
                                                                                       .brand(new BrandId(x.getVehicleBrand()))
                                                                                       .model(new ModelId(x.getVehicleModel()))
                                                                                       .build())
                                                          .toList();

        return StationResvAgg.Builder.builder()
                                     .stationId(new StationId(stationEntity.getStationId()))
                                     .vehicles(stationVehicleList)
                                     .isActive(stationEntity.getStationActive())
                                     .build();

    }

}
