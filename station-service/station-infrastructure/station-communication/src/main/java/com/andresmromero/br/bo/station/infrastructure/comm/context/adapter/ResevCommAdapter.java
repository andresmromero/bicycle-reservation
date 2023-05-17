package com.andresmromero.br.bo.station.infrastructure.comm.context.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.station.domain.context.station_reservation.repository.station.comm.PaymentCommService;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.mapper.UpdateStatusResvCmd;
import com.andresmromero.br.bo.station.domain.context.station_reservation.service.mapper.UpdateStatusResvCmdRes;
import com.andresmromero.br.bo.station.infrastructure.comm.context.http.ReservationHttpCommRest;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@InfrastructureSvc
public class ResevCommAdapter implements PaymentCommService {

    private final ReservationHttpCommRest reservationHttpCommRest;


    @Override
    public UpdateStatusResvCmdRes update_status_reservation(UpdateStatusResvCmd command, UUID reservationId) {

        return reservationHttpCommRest.update_status_reservation(command, reservationId);
    }

}
