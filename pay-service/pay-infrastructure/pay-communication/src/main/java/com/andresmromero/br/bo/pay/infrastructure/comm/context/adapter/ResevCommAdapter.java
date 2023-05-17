package com.andresmromero.br.bo.pay.infrastructure.comm.context.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.comm.PaymentCommService;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmd;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdRes;
import com.andresmromero.br.bo.pay.infrastructure.comm.context.http.ReservationHttpCommRest;
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
