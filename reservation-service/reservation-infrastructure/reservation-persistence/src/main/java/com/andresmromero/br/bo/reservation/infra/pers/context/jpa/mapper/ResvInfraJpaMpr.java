package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.*;
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
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableMainQryComm;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.CustomerResvJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.ReservationJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.exception.ResvInfraExc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
                                      .customerId(new CustomerId(c.getId()))
                                      .name(c.getName())
                                      .surname(c.getSurname())
                                      .nickname(c.getNickname())
                                      .email(new EmailVo(c.getEmail()))
                                      .build();

    }


    public ReservationJpaEnt reservation_to_reservationEntity(ReservationAgg r) {

        return ReservationJpaEnt.builder()
                                .reservationId(r.getId().getValue())
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

                                     .reservationId(new ReservationId(r.getReservationId()))
                                     .customerId(new CustomerId(r.getCustomerId()))
                                     .stationId(new StationId(r.getStationId()))
                                     .trackingId(new TrackingId(r.getTrackingId()))
                                     .status(get_reservation_status(r.getReservationStatus()))
                                     .price(new MoneyVo(r.getPrice()))
                                     .items(List.of(ReservationItem.Builder.builder().build()))
                                     .messageBox(new ArrayList<>())
                                     .build();

    }

    private ReservationStatus get_reservation_status(String reservationStatus) {

        if (reservationStatus.equals(ReservationStatus.APPROVED.name())) {
            return ReservationStatus.APPROVED;
        }
        if (reservationStatus.equals(ReservationStatus.PAID.name())) {
            return ReservationStatus.PAID;
        }
        if (reservationStatus.equals(ReservationStatus.CANCELLED.name())) {
            return ReservationStatus.CANCELLED;
        }
        if (reservationStatus.equals(ReservationStatus.PENDING.name())) {
            return ReservationStatus.PENDING;
        }
        if (reservationStatus.equals(ReservationStatus.CANCELLING.name())) {
            return ReservationStatus.CANCELLING;
        }

        throw new ResvInfraExc("reservation status no found");
    }

    public List<UUID> station_extract_stationVehicle(StationResvAgg station) {

        return station.getVehicles().stream().map(x -> x.getId().getValue()).toList();
    }


    public CustomerResvJpaEnt customer_to_customerEntity(CustomerResvAgg c) {

        return CustomerResvJpaEnt.builder()
                                 .id(c.getId().getValue())
                                 .name(c.getName())
                                 .surname(c.getSurname())
                                 .nickname(c.getNickname())
                                 .email(c.getEmail().getValue())
                                 .build();
    }

    public CustomerResvJpaEnt map_entity_to_update_model_customer(Optional<CustomerResvJpaEnt> found,
                                                                  CustomerResvAgg c) {


        found.orElseThrow(() -> new ResvInfraExc("exception thrown when client entity is not found"));
        CustomerResvJpaEnt customerFound = found.get();
        customerFound.setId(c.getId().getValue());
        customerFound.setName(c.getName());
        customerFound.setSurname(c.getSurname());
        customerFound.setEmail(c.getEmail().getValue());
        customerFound.setNickname(c.getNickname());
        return customerFound;
    }

    public StationResvAgg getAvailableMainQryComm_to_station(List<GetAvailableMainQryComm> stationList) {


        GetAvailableMainQryComm stationEntity = stationList.stream()
                                                           .findFirst()
                                                           .orElseThrow(() -> new ResvInfraExc(
                                                                   "The information coming from the station service does not correspond"));


        List<VehicleResv> stationVehicleList = stationList.stream()
                                                          .map(x -> VehicleResv.Builder.builder()
                                                                                       .vehicleId(new VehicleId(x.vehicleId()))
                                                                                       .name(x.vehicleName())
                                                                                       .price(new MoneyVo(x.vehiclePrice()))
                                                                                       .brand(new BrandId(x.vehicleBrand()))
                                                                                       .model(new ModelId(x.vehicleModel()))
                                                                                       .build())
                                                          .toList();

        return StationResvAgg.Builder.builder()
                                     .stationId(new StationId(stationEntity.stationId()))
                                     .vehicles(stationVehicleList)
                                     .isActive(stationEntity.stationActive())
                                     .build();

    }

}
