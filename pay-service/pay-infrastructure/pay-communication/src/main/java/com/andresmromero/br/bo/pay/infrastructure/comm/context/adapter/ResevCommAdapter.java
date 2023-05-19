package com.andresmromero.br.bo.pay.infrastructure.comm.context.adapter;

import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.comm.PaymentCommService;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdRes;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdx;
import com.andresmromero.br.bo.pay.infrastructure.comm.context.http.ReservationHttpCommRest;
import lombok.AllArgsConstructor;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;

import java.util.UUID;

@AllArgsConstructor
@InfrastructureSvc
public class ResevCommAdapter implements PaymentCommService {

    private final ReservationHttpCommRest reservationHttpCommRest;


    @Override
    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(3000))
    public UpdateStatusResvCmdRes update_status_reservation(UpdateStatusResvCmdx command, UUID reservationId) {

        return reservationHttpCommRest.update_status_reservation(command, reservationId);
    }

}
