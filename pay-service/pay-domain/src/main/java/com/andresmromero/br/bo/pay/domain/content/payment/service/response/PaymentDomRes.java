package com.andresmromero.br.bo.pay.domain.content.payment.service.response;

import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;

import java.util.List;

public class PaymentDomRes extends PaymentDom {


    public PaymentDomRes(PaymentAgg payment, EntryAgg entry, List<EntryHistoryAgg> entryHistory) {

        super(payment, entry, entryHistory);
    }

}
