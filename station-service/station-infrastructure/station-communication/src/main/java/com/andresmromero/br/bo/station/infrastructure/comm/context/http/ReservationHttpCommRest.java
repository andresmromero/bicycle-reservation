package com.andresmromero.br.bo.station.infrastructure.comm.context.http;

import com.andresmromero.br.bo.station.domain.context.station_reservation.service.mapper.UpdateStatusResvCmd;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.mapper.UpdateStatusResvCmdRes;
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
