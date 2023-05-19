package com.andresmromero.br.bo.pay.infrastructure.comm.context.http;

import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdRes;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdx;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "reservationservice")
public interface ReservationHttpCommRest {


    @PutMapping("/status/{reservationId}")
    UpdateStatusResvCmdRes update_status_reservation(@Valid @RequestBody UpdateStatusResvCmdx command,
                                                     @PathVariable("reservationId") UUID reservationId);

}
