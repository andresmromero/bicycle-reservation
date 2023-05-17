package com.andresmromero.br.bo.pay.infrastructure.api.context.payment.controller;

import com.andresmromero.br.bo.pay.application.context.payment.service.command.PaymentCmdSvc;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentRes;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentRes;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@AllArgsConstructor
@RestController
public class PaymentCommandCtrl {

    private final PaymentCmdSvc paymentCmdAdpt;

    @GetMapping("/payment/payment/health-check-command")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "payment-command");
        status.put("status", "ok");
        return status;
    }


    @PutMapping("/payment/receive/{reservationId}")
    public ResponseEntity<ReceivedPaymentRes> receive_payment(@PathVariable("reservationId") UUID reservationId,
                                                              @Valid @RequestBody ReceivedPaymentCmd command) {

        ReceivedPaymentCmd newCommand = command.withGenericValues(reservationId);
        ReceivedPaymentRes res = paymentCmdAdpt.received_payment(newCommand);
        return ResponseEntity.ok(res);

    }

    @PutMapping("/payment/cancel/{reservationId}")
    public ResponseEntity<CanceledPaymentRes> cancel_payment(@PathVariable("reservationId") UUID reservationId,
                                                             @Valid @RequestBody CanceledPaymentCmd command) {

        CanceledPaymentCmd newCommand = command.withGenericValues(reservationId);
        paymentCmdAdpt.cancelled_payment(newCommand);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}
