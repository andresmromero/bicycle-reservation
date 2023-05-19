package com.andresmromero.br.bo.station.infrastructure.api.context.controller;

import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.StationReservationCmdSvs;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.reservation.receive.ReceiveReservationRes;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.create.CreateStatResevCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.delete.Id.DelStatResevByIdCmd;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.command.stat_resev.update.byId.UpdStatResevIdCmd;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PutMapping("/receive/{reservationId}")
    public ResponseEntity<ReceiveReservationRes> receive_reservation(@PathVariable("reservationId") UUID reservationId,
                                                                     @Valid @RequestBody ReceiveReservationCmd command) {

        ReceiveReservationRes resp = stationReservationCmdSvs.receive_reservation(command);
        return ResponseEntity.ok(resp);

    }

    @PostMapping("/reservations")
    public ResponseEntity<?> save_customer(@Valid @RequestBody CreateStatResevCmd command) {

        stationReservationCmdSvs.create_stationReservEntity(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<?> update_customer_by_id(@PathVariable("id") UUID id,
                                                   @Valid @RequestBody UpdStatResevIdCmd command) {

        stationReservationCmdSvs.update_stationReservEntity(command.withId(id));
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<?> delete_customer_by_id(@PathVariable("id") UUID id) {

        stationReservationCmdSvs.delete_stationReservEntity(new DelStatResevByIdCmd(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
