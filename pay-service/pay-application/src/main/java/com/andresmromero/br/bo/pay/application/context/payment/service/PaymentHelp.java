package com.andresmromero.br.bo.pay.application.context.payment.service;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.EntryId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.pay.application.context.exception.PayAppExc;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled.CanceledPaymentCmd;
import com.andresmromero.br.bo.pay.application.context.payment.service.command.received.ReceivedPaymentCmd;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.EntryHistoryPersSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.EntryPersSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.PaymentPersSvc;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ApplicationComp
public class PaymentHelp {

    private final EntryPersSvc entryPersSvc;
    private final EntryHistoryPersSvc entryHistoryPersSvc;
    private final PaymentPersSvc paymentPersSvc;


    public List<EntryHistoryAgg> get_entry_history(CustomerId customerId) {

        List<EntryHistoryAgg> entryHistory = entryHistoryPersSvc.get_by_customerId(customerId);

        if (entryHistory.isEmpty()) {
            return new ArrayList<>();
        }
        return entryHistory;
    }

    public void save_payment(PaymentAgg payment) {

        paymentPersSvc.save(payment);

    }

    public void save_entry(EntryAgg entry) {

        entryPersSvc.save(entry);

    }

    public void save_entry_history(List<EntryHistoryAgg> entryHistoryList) {

        entryHistoryPersSvc.save(entryHistoryList.get(entryHistoryList.size() - 1));

    }

    public PaymentAgg get_payment_with_reservationId(ReservationId reservationId) {

        return paymentPersSvc.get_by_reservationId(reservationId).orElseThrow(

                () -> new PayAppExc("Payment no found"));
    }

    public EntryAgg get_entry(CustomerId customerId, ReceivedPaymentCmd command) {

        return EntryAgg.Builder.builder()
                               .id(new EntryId(command.reservationId()))
                               .customerId(new CustomerId(command.customerId()))
                               .total(new MoneyVo(command.entry()))
                               .build();
    }

    public EntryAgg get_entry_cancel(CustomerId customerId, CanceledPaymentCmd command) {

        return EntryAgg.Builder.builder()
                               .id(new EntryId(command.reservationId()))
                               .customerId(new CustomerId(command.customerId()))
                               .total(new MoneyVo(command.entry()))
                               .build();
    }

}
