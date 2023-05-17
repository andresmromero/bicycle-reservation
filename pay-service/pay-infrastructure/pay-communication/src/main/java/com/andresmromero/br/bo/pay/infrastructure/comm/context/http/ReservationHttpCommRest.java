package com.andresmromero.br.bo.pay.infrastructure.comm.context.http;

import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmd;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdRes;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@FeignClient(name = "reservationservice")
public interface ReservationHttpCommRest {


    @PutMapping("/status/{reservationId}")
    UpdateStatusResvCmdRes update_status_reservation(@Valid @RequestBody UpdateStatusResvCmd command,
                                                     @PathVariable("reservationId") UUID reservationId);

}
