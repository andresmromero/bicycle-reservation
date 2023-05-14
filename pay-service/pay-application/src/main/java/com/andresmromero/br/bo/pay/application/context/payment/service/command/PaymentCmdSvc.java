package com.andresmromero.br.bo.pay.application.context.payment.service.command;

import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentRes;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentRes;

public interface PaymentCmdSvc {

    ReceivedPaymentRes received_payment(ReceivedPaymentCmd command);

    CanceledPaymentRes cancelled_payment(CanceledPaymentCmd command);

}
