package com.andresmromero.br.bo.reservation.infrastructure.comm.context.http;

import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableComm;
import com.andresmromero.br.bo.reservation.domain.context.reservation.service.comm.GetAvailableQryComm;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "stationservice")
public interface StationHttpCommRest {

    @PostMapping("/available")
    GetAvailableQryComm get_available(@Valid @RequestBody GetAvailableComm query);

}