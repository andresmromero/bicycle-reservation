package com.andresmromero.br.bo.station.infrastructure.api.context.controller;

import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.StationQryAdpt;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.GetAvailableQry;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp.GetAvailableQryResp;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@AllArgsConstructor
@RestController
public class StationReservationQueryCtrl {

    private final StationQryAdpt stationQryAdpt;

    @GetMapping("health-check-query")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "station-query");
        status.put("status", "ok");
        return status;
    }

    @PostMapping("/available")
    public ResponseEntity<GetAvailableQryResp> receive_reservation(@Valid @RequestBody GetAvailableQry command) {

        GetAvailableQryResp resp = stationQryAdpt.get_ent_stationReservation(command);
        return ResponseEntity.ok(resp);

    }

}
