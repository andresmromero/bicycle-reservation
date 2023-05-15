package com.andresmromero.br.bo.station.infrastructure.api.context.controller;

import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.StationReservationCmdSvs;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationRes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class StationReservationCommandCtrl {

    private final StationReservationCmdSvs stationReservationCmdSvs;

    @GetMapping("/station/payment/health-check-command")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "station-command");
        status.put("status", "ok");
        return status;
    }

    @PatchMapping("/receive/{reservationId}")
    public ResponseEntity<ReceiveReservationRes> receive_reservation(@PathVariable("reservationId") UUID reservationId,
                                                                 @Valid @RequestBody ReceiveReservationCmd command) {

        ReceiveReservationRes resp = stationReservationCmdSvs.receive_reservation(command);
        return ResponseEntity.ok(resp);

    }

}
