package com.andresmromero.br.bo.pay.application.context.payment.service;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.pay.application.context.exception.PayAppExc;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.EntryHistoryPersSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.EntryPersSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.PaymentPersSvc;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@ApplicationComp
public class PaymentHelp {

    private final EntryPersSvc entryPersSvc;
    private final EntryHistoryPersSvc entryHistoryPersSvc;
    private final PaymentPersSvc paymentPersSvc;


    public EntryAgg get_entry(CustomerId id) {

        return entryPersSvc.get_by_customerId(id)
                           .orElseThrow(() -> new PayAppExc("No entries related to the user are found"));

    }

    public List<EntryHistoryAgg> get_entry_history(CustomerId customerId) {

        return entryHistoryPersSvc.get_by_customerId(customerId);
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

}
