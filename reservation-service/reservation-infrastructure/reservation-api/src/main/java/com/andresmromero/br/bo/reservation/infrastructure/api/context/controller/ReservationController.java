package com.andresmromero.br.bo.reservation.infrastructure.api.context.controller;

import com.andresmromero.br.bo.reservation.infrastructure.comm.context.http.CustomerHttpCommRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("reservation")
public class ReservationController {

    private CustomerHttpCommRest customerHttpCommRest;

    @Autowired
    public ReservationController(CustomerHttpCommRest customerHttpCommRest) {
        this.customerHttpCommRest = customerHttpCommRest;
    }

    @GetMapping("/health-check")
    public HashMap<String, String> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put(
                "application",
                "reservation");
        status.put(
                "status",
                "ok");
        return status;
    }
}
