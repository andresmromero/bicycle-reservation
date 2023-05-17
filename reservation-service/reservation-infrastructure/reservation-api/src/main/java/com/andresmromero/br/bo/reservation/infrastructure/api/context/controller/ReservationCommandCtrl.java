package com.andresmromero.br.bo.reservation.infrastructure.api.context.controller;

import com.andresmromero.br.bo.reservation.application.context.service.command.ReservationCmdSvc;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.create.CreateCustomerCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.delete.byId.DeleteCustomerByIdCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.customer.update.byId.UpdateResevCustomerByIdCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmdRes;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status.UpdateStatusResvCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.update.status.UpdateStatusResvCmdRes;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class ReservationCommandCtrl {


    private final ReservationCmdSvc reservationCmdSvc;


    public ReservationCommandCtrl(ReservationCmdSvc reservationCmdSvc) {

        this.reservationCmdSvc = reservationCmdSvc;
    }

    @Autowired


    @GetMapping("/health-check-command")
    public HashMap<String, String> index() {


        HashMap<String, String> status = new HashMap<>();
        status.put("application", "reservation-command");
        status.put("status", "ok");
        return status;
    }

    @PostMapping("/")
    public ResponseEntity<CreateReservationCmdRes> create_reservation(@Valid @RequestBody CreateReservationCmd command) {

        CreateReservationCmdRes res = reservationCmdSvc.create_reservation(command);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

    @PutMapping("/status/{reservationId}")
    public ResponseEntity<UpdateStatusResvCmdRes> update_status_reservation(@Valid @RequestBody UpdateStatusResvCmd command,
                                                                            @PathVariable("reservationId") UUID reservationId) {

        UpdateStatusResvCmd addReservation = command.withReservationId(reservationId);
        UpdateStatusResvCmdRes res = reservationCmdSvc.update_status(addReservation);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }


    @PostMapping("/customer")
    public ResponseEntity<?> save_customer(@Valid @RequestBody CreateCustomerCmd command) {

        reservationCmdSvc.save_customer(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity<?> update_customer_by_id(@PathVariable("id") UUID id,
                                                   @Valid @RequestBody UpdateResevCustomerByIdCmd command) {

        reservationCmdSvc.update_customer_by_id(command.withId(id));
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<?> delete_customer_by_id(@PathVariable("id") UUID id) {

        reservationCmdSvc.delete_customer_by_id(new DeleteCustomerByIdCmd(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}