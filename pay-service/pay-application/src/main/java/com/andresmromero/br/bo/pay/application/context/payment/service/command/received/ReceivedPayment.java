package com.andresmromero.br.bo.pay.application.context.payment.service.command.received;

import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.pay.application.context.mapper.PayAppMapper;
import com.andresmromero.br.bo.pay.application.context.payment.service.PaymentHelp;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.comm.PaymentCommService;
import com.andresmromero.br.bo.pay.domain.content.payment.service.PaymentDomSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmd;
import com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper.UpdateStatusResvCmdRes;
import com.andresmromero.br.bo.pay.domain.content.payment.service.response.PaymentDom;
import lombok.AllArgsConstructor;

import java.util.List;

@ApplicationComp
@AllArgsConstructor
public class ReceivedPayment {

    private final PayAppMapper payAppMapper;
    private final PaymentHelp paymentHelp;

    private final PaymentDomSvc paymentDomSvc;
    private final PaymentCommService paymentCommService;

    public ReceivedPaymentRes invoke(ReceivedPaymentCmd command) {

        CustomerId customerId = new CustomerId(command.customerId());

        PaymentAgg payment = payAppMapper.receivedPaymentCmd(command);

        EntryAgg entry = paymentHelp.get_entry(customerId, command);

        List<EntryHistoryAgg> entryHistoryList = paymentHelp.get_entry_history(customerId);

        PaymentDom paymentRes = paymentDomSvc.initPayment(payment, entry, entryHistoryList);

        PaymentAgg payment1 = paymentRes.getPayment();
        paymentHelp.save_payment(payment1);

        EntryAgg entry1 = paymentRes.getEntry();
        paymentHelp.save_entry(entry1);
        List<EntryHistoryAgg> entryHistory = paymentRes.getEntryHistory();
        paymentHelp.save_entry_history(entryHistory);

        if (payment.getMessageBox().isEmpty()) {
            UpdateStatusResvCmd changeStatusReservation =
                    new UpdateStatusResvCmd(ReservationStatus.PENDING.name(), ReservationStatus.PAID.name());

            UpdateStatusResvCmdRes changeStatusReservationRes = paymentCommService.update_status_reservation(
                    changeStatusReservation,
                    payment1.getReservationId().getValue());

            if (changeStatusReservationRes != null) {

                payment.getMessageBox().add(changeStatusReservationRes.getMessage().toString());
            }
        }


        return ReceivedPaymentRes.builder().message(paymentRes.getPayment().getMessageBox()).build();
    }

}
