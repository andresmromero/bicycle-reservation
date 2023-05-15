package com.andresmromero.br.bo.station.domain.context.station_reservation.service;

import com.andresmromero.br.bo.context.domain.model.enums.ReservationReceivedStatus;
import com.andresmromero.br.bo.station.domain.context.station_reservation.model.station.StationAgg;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.response.StationDom;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.response.StationDomRes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationDomAdpt implements StationDomSvc {


    @Override
    public StationDom valid_reservation(StationAgg station, List<String> messageBox) {

        station.val_reservation(messageBox);

        if (messageBox.isEmpty()) {
            station.generate_approval_reservation(ReservationReceivedStatus.APPROVED);
        }

        return new StationDomRes(station, messageBox);

    }

}
