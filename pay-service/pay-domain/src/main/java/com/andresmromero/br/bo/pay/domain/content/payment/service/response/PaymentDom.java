package com.andresmromero.br.bo.pay.domain.content.payment.service.response;

import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;

import java.util.List;

public abstract class PaymentDom {

    private final PaymentAgg payment;
    private final EntryAgg entry;
    private final List<EntryHistoryAgg> entryHistory;

    public PaymentDom(PaymentAgg payment, EntryAgg entry, List<EntryHistoryAgg> entryHistory) {

        this.payment = payment;
        this.entry = entry;
        this.entryHistory = entryHistory;
    }

    public PaymentAgg getPayment() {

        return payment;
    }

    public EntryAgg getEntry() {

        return entry;
    }

    public List<EntryHistoryAgg> getEntryHistory() {

        return entryHistory;
    }

}
