package com.andresmromero.br.bo.reservation.infrastructure.api.context.controller;

import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmd;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationCmdRes;
import com.andresmromero.br.bo.reservation.application.context.service.command.reservation.create.CreateReservationHdl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class ReservationCommandCtrl {

    private final CreateReservationHdl createReservationHdl;

    @Autowired
    public ReservationCommandCtrl(CreateReservationHdl createReservationHdl) {

        this.createReservationHdl = createReservationHdl;
    }

    @GetMapping("/health-check-command")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "reservation-command");
        status.put("status", "ok");
        return status;
    }

    @PostMapping("/")
    public ResponseEntity<CreateReservationCmdRes> create_reservation(@Valid @RequestBody CreateReservationCmd command) {

        CreateReservationCmdRes res = createReservationHdl.handle(command);

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }

}