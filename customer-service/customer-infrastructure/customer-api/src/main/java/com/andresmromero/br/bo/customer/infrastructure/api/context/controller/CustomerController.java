package com.andresmromero.br.bo.customer.infrastructure.api.context.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CustomerController {
    @GetMapping("/health-check")
    public HashMap<String, String> index() {
        HashMap<String, String> status = new HashMap<>();
        status.put(
                "application",
                "customer");
        status.put(
                "status",
                "ok");
        return status;
    }
}
