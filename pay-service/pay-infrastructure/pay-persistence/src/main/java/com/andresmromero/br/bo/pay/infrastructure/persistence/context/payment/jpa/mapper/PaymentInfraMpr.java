package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.mapper;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.EntryId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.PaymentId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.enums.TransactionType;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureComp;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.exception.PayInfraExc;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.EntryHistoryJpaEnt;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.EntryJpaEnt;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.PaymentJpaEnt;

@InfrastructureComp
public class PaymentInfraMpr {

    public EntryHistoryJpaEnt entryHistory_to_entryHistoryEntity(EntryHistoryAgg eh) {

        return EntryHistoryJpaEnt.builder()
                                 .entryHistoryId(eh.getId().getValue())
                                 .customerId(eh.getCustomerId().getValue())
                                 .total(eh.getTotal().getAmount())
                                 .type(eh.getTransactionType())
                                 .build();

    }

    public EntryHistoryAgg entryHistoryEntity_to_entryHistory(EntryHistoryJpaEnt eh) {

        TransactionType transactionType = get_transaction_type(eh.getType().name());

        return EntryHistoryAgg.Builder.builder()
                                      .customerId(new CustomerId(eh.getCustomerId()))
                                      .total(new MoneyVo(eh.getTotal()))
                                      .transactionType(transactionType)
                                      .build();
    }

    private TransactionType get_transaction_type(String name) {

        String status = name.toUpperCase();
        if (status.equals(TransactionType.CREDIT.name())) {
            return TransactionType.CREDIT;
        }
        if (status.equals(TransactionType.DEBIT.name())) {
            return TransactionType.DEBIT;
        }
        throw new PayInfraExc("error transaction type not found");
    }

    public EntryJpaEnt entry_to_entryEntity(EntryAgg e) {

        return EntryJpaEnt.builder()
                          .id(e.getId().getValue())
                          .customerId(e.getCustomerId().getValue())
                          .totalEntry(e.getTotal().getAmount())
                          .build();
    }

    public EntryAgg entryEntity_to_entity(EntryJpaEnt e) {


        return EntryAgg.Builder.builder()
                               .id(new EntryId(e.getId()))
                               .customerId(new CustomerId(e.getCustomerId()))
                               .total(new MoneyVo(e.getTotalEntry()))
                               .build();

    }

    public PaymentJpaEnt payment_to_paymentEntity(PaymentAgg p) {


        return PaymentJpaEnt.builder()
                            .id(p.getReservationId().getValue())
                            .customerId(p.getCustomerId().getValue())
                            .reservationId(p.getReservationId().getValue())
                            .price(p.getPrice().getAmount())
                            .status(p.getStatus())
                            .build();
    }


    public PaymentAgg paymentEntity_to_payment(PaymentJpaEnt p) {

        return PaymentAgg.Builder.builder()
                                 .paymentId(new PaymentId(p.getReservationId()))
                                 .reservationId(new ReservationId(p.getReservationId()))
                                 .price(new MoneyVo(p.getPrice()))
                                 .customerId(new CustomerId(p.getCustomerId()))
                                 .status(p.getStatus())
                                 .build();

    }

}
