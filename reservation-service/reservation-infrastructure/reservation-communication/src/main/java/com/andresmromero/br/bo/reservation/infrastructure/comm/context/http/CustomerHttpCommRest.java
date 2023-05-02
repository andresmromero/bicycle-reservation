package com.andresmromero.br.bo.reservation.infrastructure.comm.context.http;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;

@FeignClient(name = "customerservice")
public interface CustomerHttpCommRest {

    @GetMapping("customer/health-check")
    public HashMap<String, String> index();
}
