package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.adapter;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.EntryPersSvc;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.EntryJpaEnt;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.mapper.PaymentInfraMpr;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.repository.EntryJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@InfrastructureSvc
public class EntryJpaAdpt implements EntryPersSvc {

    private final EntryJpaRepo entryJpaRepo;
    private final PaymentInfraMpr paymentInfraMpr;

    @Autowired
    public EntryJpaAdpt(EntryJpaRepo entryJpaRepo) {

        paymentInfraMpr = new PaymentInfraMpr();
        this.entryJpaRepo = entryJpaRepo;
    }

    @Override
    public EntryAgg save(EntryAgg entry) {

        EntryJpaEnt toEntity = paymentInfraMpr.entry_to_entryEntity(entry);

        entryJpaRepo.save(toEntity);

        return entry;
    }

    @Override
    public Optional<EntryAgg> get_by_customerId(CustomerId customerId) {

        return entryJpaRepo.findByCustomerId(customerId.getValue()).map(paymentInfraMpr::entryEntity_to_entity);
    }

}
