package com.andresmromero.br.bo.reservation.application.context.mapper;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.VehicleId;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.EmailVo;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.create.CreateCustomerCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId.UpdateResevCustomerByIdCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmdRes;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.resp.GetAllCustomerQryElem;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQryRes;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.ReservationItem;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.VehicleResv;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station.StationResvAgg;

import java.util.List;
import java.util.function.Function;

@ApplicationComp
public class ReservationAppMrp {


    private static List<VehicleResv> createReservationCmd_vehicleList(CreateReservationCmd c) {

        return c.itemsList()
                .stream()
                .map(x -> VehicleResv.Builder.builder().vehicleId(new VehicleId(x.vehicleId())).build())
                .toList();
    }

    private static Function<CustomerResvAgg, GetAllCustomerQryElem> mapper_customerItem_to_GetAllCustomerQryElemItem() {

        return c -> GetAllCustomerQryElem.builder()
                                         .id(c.getId().getValue())
                                         .name(c.getName())
                                         .surname(c.getSurname())
                                         .email(c.getEmail().getValue())
                                         .nickname(c.getNickname())
                                         .build();
    }

    public StationResvAgg createReservationCmd_listVehicle(CreateReservationCmd c) {

        return StationResvAgg.Builder.builder()
                                     .stationId(new StationId(c.stationId()))
                                     .vehicles(createReservationCmd_vehicleList(c))
                                     .build();

    }


    //    public CreateReservationCmdRes reservation_to_createReservationCmdRes(ReservationAgg reservation) {
    //
    //        return CreateReservationCmdRes.builder().message(List.of("Reservation created successfully")).build();
    //
    //    }

    public ReservationAgg createReservationCmd_to_reservation(CreateReservationCmd c) {


        List<ReservationItem> reservationItemList = c.itemsList().stream().map(x -> {
            VehicleId vehicleId = new VehicleId(x.vehicleId());
            return ReservationItem.Builder.builder()
                                          .vehicle(VehicleResv.Builder.builder().vehicleId(vehicleId).build())
                                          .price(new MoneyVo(x.price()))
                                          .quantity(x.quantity())
                                          .total(new MoneyVo(x.total()))
                                          .build();
        }).toList();

        return ReservationAgg.Builder.builder()
                                     .customerId(new CustomerId(c.customerId()))
                                     .stationId(new StationId(c.stationId()))
                                     .price(new MoneyVo(c.price()))
                                     .items(reservationItemList)
                                     .build();

    }

    public FindReservationByIdQryRes reservation_to_findReservationByIdQryRes(ReservationAgg model) {

        return FindReservationByIdQryRes.builder()
                                        .trackingId(model.getTrackingId().getValue())
                                        .reservationStatus(model.getStatus())
                                        .messages(model.getMessageBox())
                                        .build();
    }

    public CreateReservationCmdRes reservation_to_createReservationCmdRes(List<String> messageBox) {

        return CreateReservationCmdRes.builder().message(messageBox).build();
    }

    public CustomerResvAgg createCustomerCmd_to_customer(CreateCustomerCmd c) {

        return CustomerResvAgg.Builder.builder()
                                      .customerId(new CustomerId(c.id()))
                                      .name(c.name())
                                      .surname(c.surname())
                                      .nickname(c.nickname())
                                      .email(new EmailVo(c.email()))
                                      .build();
    }

    public CustomerResvAgg updateCustomerCmd_to_customer(UpdateResevCustomerByIdCmd c) {

        return CustomerResvAgg.Builder.builder()
                                      .customerId(new CustomerId(c.id()))
                                      .name(c.name())
                                      .surname(c.surname())
                                      .nickname(c.nickname())
                                      .email(new EmailVo(c.email()))
                                      .build();

    }

    public GetAllCustomersQryResponse customer_to_getAllCustomerQryResponse(List<CustomerResvAgg> customerList) {

        List<GetAllCustomerQryElem> elements =
                customerList.stream().map(mapper_customerItem_to_GetAllCustomerQryElemItem()).toList();

        return GetAllCustomersQryResponse.builder().customers(elements).build();
    }

    public GetCustomerByIdQryResp customer_to_getByIdCustomerQryResp(CustomerResvAgg c) {

        return GetCustomerByIdQryResp.builder()
                                     .id(c.getId().getValue())
                                     .name(c.getName())
                                     .surname(c.getSurname())
                                     .email(c.getEmail().getValue())
                                     .nickname(c.getNickname())
                                     .build();
    }

}





