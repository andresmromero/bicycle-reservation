package com.andresmromero.br.bo.pay.application.context.payment.service.command.received;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import lombok.AllArgsConstructor;

@ApplicationComp
@AllArgsConstructor
public class ReceivedPaymentHdl {

    private final ReceivedPayment receivedPayment;

    public ReceivedPaymentRes handle(ReceivedPaymentCmd command) {

        return receivedPayment.invoke(command);

    }

}
