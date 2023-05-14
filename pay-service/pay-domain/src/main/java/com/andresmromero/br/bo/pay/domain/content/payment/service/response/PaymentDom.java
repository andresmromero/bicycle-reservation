package com.andresmromero.br.bo.pay.domain.content.payment.service.response;

import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;

public abstract class PaymentDom {

    private final PaymentAgg payment;

    public PaymentDom(PaymentAgg payment) {

        this.payment = payment;
    }

    public PaymentAgg getPayment() {

        return payment;
    }

}
