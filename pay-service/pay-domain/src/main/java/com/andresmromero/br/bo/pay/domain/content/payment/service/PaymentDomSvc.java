package com.andresmromero.br.bo.pay.domain.content.payment.service;

import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.service.response.PaymentDom;

import java.util.List;

public interface PaymentDomSvc {

    PaymentDom initPayment(PaymentAgg payment, EntryAgg entry, List<EntryHistoryAgg> entryHistoryList);

    PaymentDom cancelPayment(PaymentAgg payment, EntryAgg entry, List<EntryHistoryAgg> entryHistoryList);

}
