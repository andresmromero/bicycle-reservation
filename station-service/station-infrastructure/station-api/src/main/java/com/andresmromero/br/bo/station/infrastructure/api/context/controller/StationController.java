package com.andresmromero.br.bo.station.infrastructure.api.context.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("station")
public class StationController {

    @GetMapping("/health-check")
    public HashMap<String, String> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put(
                "application",
                "station");
        status.put(
                "status",
                "ok");
        return status;
    }

}
