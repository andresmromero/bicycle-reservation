package com.andresmromero.br.bo.reservation.infrastructure.api.context.controller;

import com.andresmromero.br.bo.reservation.application.context.service.query.ReservationQrySvc;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.GetCustomerByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQry;
import com.andresmromero.br.bo.reservation.application.context.service.query.tracking.byId.FindReservationByIdQryRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class ReservationQueryCtrl {

    private final ReservationQrySvc reservationQrySvc;

    @Autowired
    public ReservationQueryCtrl(ReservationQrySvc reservationQrySvc) {this.reservationQrySvc = reservationQrySvc;}


    @GetMapping("/health-check-query")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "reservation-query");
        status.put("status", "ok");
        return status;
    }

    @GetMapping("/tracking/{trackingId}")
    public ResponseEntity<FindReservationByIdQryRes> find_by_tracking_reservation(@PathVariable("trackingId") UUID trackingId) {

        FindReservationByIdQryRes res = reservationQrySvc.find_by_id_tracking(new FindReservationByIdQry(trackingId));

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    @GetMapping("/customer")
    public ResponseEntity<?> get_all_customer() {

        GetAllCustomersQryResponse resp = reservationQrySvc.get_all_customers();
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<GetCustomerByIdQryResp> get_customer_by_id(@PathVariable("id") UUID id) {

        GetCustomerByIdQryResp resp = reservationQrySvc.get_customer_by_id(new GetCustomerByIdQry(id));
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

}