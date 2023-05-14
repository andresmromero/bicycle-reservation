package com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class CanceledPaymentHdl {

    private final CanceledPayment canceledPayment;

    public CanceledPaymentRes handle(CanceledPaymentCmd command) {

        return canceledPayment.invoke(command);

    }

}
