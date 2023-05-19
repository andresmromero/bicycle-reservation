package com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.station.application.context.station_reservation.service.query.get.available.resp.GetAvailableQryResp;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class GetAvailableHdl {

    private final GetAvailable getAvailable;

    @Transactional
    public GetAvailableQryResp handle(GetAvailableQry query) {

        return getAvailable.invoke(query);

    }

}
