package com.andresmromero.br.bo.pay.application.context.mapper;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentCmd;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.exception.PayInfraExc;

@ApplicationComp
public class PayAppMapper {


    private static PaymentStatus get_payment_status(ReceivedPaymentCmd c) {

        String status = c.paymentStatus().toUpperCase();
        if (status.equals(PaymentStatus.RECEIVED.name())) {
            return PaymentStatus.RECEIVED;
        }
        if (status.equals(PaymentStatus.FAILED.name())) {
            return PaymentStatus.FAILED;
        }
        if (status.equals(PaymentStatus.CANCELED.name())) {
            return PaymentStatus.CANCELED;
        }
        if (status.equals(PaymentStatus.PENDING.name())) {
            return PaymentStatus.PENDING;
        }
        throw new PayInfraExc("The state of Payment does not exist");
    }

    private static PaymentStatus get_payment_status_cancelled(CanceledPaymentCmd c) {

        String status = c.paymentStatus().toUpperCase();
        if (status.equals(PaymentStatus.RECEIVED.name())) {
            return PaymentStatus.RECEIVED;
        }
        if (status.equals(PaymentStatus.FAILED.name())) {
            return PaymentStatus.FAILED;
        }
        if (status.equals(PaymentStatus.CANCELED.name())) {
            return PaymentStatus.CANCELED;
        }
        if (status.equals(PaymentStatus.PENDING.name())) {
            return PaymentStatus.PENDING;
        }
        throw new PayInfraExc("The state of Payment does not exist");
    }

    public PaymentAgg receivedPaymentCmd(ReceivedPaymentCmd c) {

        PaymentStatus paymentStatus = get_payment_status(c);


        return PaymentAgg.Builder.builder()
                                 .reservationId(new ReservationId(c.reservationId()))
                                 .price(new MoneyVo(c.price()))
                                 .customerId(new CustomerId(c.customerId()))
                                 .status(paymentStatus)
                                 .build();
    }

    public PaymentAgg cancelledPaymentCmd(CanceledPaymentCmd c) {

        PaymentStatus paymentStatus = get_payment_status_cancelled(c);


        return PaymentAgg.Builder.builder()
                                 .reservationId(new ReservationId(c.reservationId()))
                                 .price(new MoneyVo(c.price()))
                                 .customerId(new CustomerId(c.customerId()))
                                 .status(paymentStatus)
                                 .build();
    }

}
