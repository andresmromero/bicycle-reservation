package com.andresmromero.br.bo.pay.domain.content.payment.service;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.EntryHistoryId;
import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
import com.andresmromero.br.bo.context.domain.model.enums.TransactionType;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.service.response.PaymentDom;
import com.andresmromero.br.bo.pay.domain.content.payment.service.response.PaymentDomRes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentDomAdpt implements PaymentDomSvc {

    @Override
    public PaymentDom initPayment(PaymentAgg payment, EntryAgg entry, List<EntryHistoryAgg> entryHistoryList) {

        List<String> messageBox = new ArrayList<>();

        payment.val_init(messageBox);
        payment.init();
        val_entry(payment, entry, messageBox);
        deduct_entry(payment, entry);
        update_entry_history(payment, entryHistoryList, TransactionType.DEBIT);

        if (messageBox.isEmpty()) {
            payment.setStatus(PaymentStatus.RECEIVED);
        } else {
            payment.setStatus(PaymentStatus.CANCELED);
        }
        payment.setMessageBox(messageBox);
        return new PaymentDomRes(payment);
    }

    private void update_entry_history(PaymentAgg payment,
                                      List<EntryHistoryAgg> entryHistoryList,
                                      TransactionType transactionType) {


        entryHistoryList.add(EntryHistoryAgg.Builder.builder()
                                                    .id(new EntryHistoryId(UUID.randomUUID()))
                                                    .customerId(payment.getCustomerId())
                                                    .total(payment.getPrice())
                                                    .transactionType(transactionType)
                                                    .build());

    }


    private void deduct_entry(PaymentAgg payment, EntryAgg entry) {

        entry.subtract_money(payment.getPrice());

    }

    private void val_entry(PaymentAgg payment, EntryAgg entry, List<String> messageBox) {


        if (payment.getPrice().isGreaterThan(entry.getTotal())) {
            messageBox.add("Dinero insuficiente para adquirir la reserva");
        }

    }

    @Override
    public PaymentDom cancelPayment(PaymentAgg payment, EntryAgg entry, List<EntryHistoryAgg> entryHistoryList) {


        List<String> messageBox = new ArrayList<>();

        payment.val_init(messageBox);
        add_entry(payment, entry);
        update_entry_history(payment, entryHistoryList, TransactionType.DEBIT);


        if (messageBox.isEmpty()) {
            payment.setStatus(PaymentStatus.CANCELED);
        } else {
            payment.setStatus(PaymentStatus.FAILED);
        }

        payment.setMessageBox(messageBox);
        return new PaymentDomRes(payment);

    }

    private void add_entry(PaymentAgg payment, EntryAgg entry) {

        entry.add_entry_with(payment.getPrice());

    }

}
