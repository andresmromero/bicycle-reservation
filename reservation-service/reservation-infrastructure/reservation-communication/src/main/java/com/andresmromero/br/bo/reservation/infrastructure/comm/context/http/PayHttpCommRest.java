package com.andresmromero.br.bo.reservation.infrastructure.comm.context.http;

import com.andresmromero.br.bo.reservation.infrastructure.comm.context.service.pay.send.SendPay;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@FeignClient(name = "payservice")
public interface PayHttpCommRest {

    @GetMapping("/payment/payment/health-check-command")
    HashMap<String, String> index();

    @PutMapping("/payment/receive/{reservationId}")
    List<String> receive_payment(@PathVariable("reservationId") UUID reservationId,
                                 @Valid @RequestBody SendPay command);

}
