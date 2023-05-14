package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.adapter;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.PaymentAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.PaymentPersSvc;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.PaymentJpaEnt;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.mapper.PaymentInfraMpr;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.repository.PaymentJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.UUID;


@InfrastructureSvc
public class PaymentJpaAdpt implements PaymentPersSvc {

    private final PaymentJpaRepo paymentJpaRepo;
    private final PaymentInfraMpr paymentInfraMpr;

    @Autowired
    public PaymentJpaAdpt(PaymentJpaRepo paymentJpaRepo, PaymentInfraMpr paymentInfraMpr) {

        this.paymentJpaRepo = paymentJpaRepo;
        this.paymentInfraMpr = paymentInfraMpr;
    }

    @Override
    public PaymentAgg save(PaymentAgg payment) {


        PaymentJpaEnt toEntity = paymentInfraMpr.payment_to_paymentEntity(payment);

        paymentJpaRepo.save(toEntity);
        return payment;
    }

    @Override
    public Optional<PaymentAgg> get_by_reservationId(ReservationId reservationId) {

        UUID id = reservationId.getValue();
        return paymentJpaRepo.findByReservationId(id).map(paymentInfraMpr::paymentEntity_to_payment);

    }

}
