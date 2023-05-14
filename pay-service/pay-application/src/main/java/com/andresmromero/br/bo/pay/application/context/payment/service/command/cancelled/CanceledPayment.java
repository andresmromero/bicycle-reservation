package com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.pay.application.context.mapper.PayAppMapper;
import com.andresmromero.br.bo.pay.application.context.payment.service.PaymentHelp;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.service.PaymentDomSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.service.response.PaymentDom;
import lombok.AllArgsConstructor;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class CanceledPayment {

    private final PayAppMapper payAppMapper;
    private final PaymentHelp paymentHelp;

    private final PaymentDomSvc paymentDomSvc;

    public CanceledPaymentRes invoke(CanceledPaymentCmd command) {


        CustomerId customerId = new CustomerId(command.customerId());
        ReservationId reservationId = new ReservationId(command.reservationId());


        PaymentAgg payment = paymentHelp.get_payment_with_reservationId(reservationId);

        EntryAgg entry = paymentHelp.get_entry(customerId);
        List<EntryHistoryAgg> entryHistoryList = paymentHelp.get_entry_history(customerId);

        PaymentDom paymentRes = paymentDomSvc.cancelPayment(payment, entry, entryHistoryList);

        paymentHelp.save_payment(paymentRes.getPayment());
        if (paymentRes.getPayment().getMessageBox().isEmpty()) {
            paymentHelp.save_entry(entry);
            paymentHelp.save_entry_history(entryHistoryList);
        }

        return CanceledPaymentRes.builder().message(paymentRes.getPayment().getMessageBox()).build();
    }

}
