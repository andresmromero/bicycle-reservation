package com.andresmromero.br.bo.pay.application.context.payment.service.command;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentHdl;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentRes;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentHdl;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentRes;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class PaymentCmdAdpt implements PaymentCmdSvc {

    private final ReceivedPaymentHdl receivedPaymentHdl;
    private final CanceledPaymentHdl canceledPaymentHdl;

    @Override
    public ReceivedPaymentRes received_payment(ReceivedPaymentCmd command) {

        return receivedPaymentHdl.handle(command);

    }

    @Override
    public CanceledPaymentRes cancelled_payment(CanceledPaymentCmd command) {

        return canceledPaymentHdl.handle(command);

    }

}
