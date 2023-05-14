package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.adapter;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;
import com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence.EntryHistoryPersSvc;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.exception.PayInfraExc;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity.EntryHistoryJpaEnt;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.mapper.PaymentInfraMpr;
import com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.repository.EntryHistoryJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@InfrastructureSvc
public class EntryHistoryJpaAdpt implements EntryHistoryPersSvc {

    private final EntryHistoryJpaRepo entryHistoryJpaRepo;

    private final PaymentInfraMpr paymentInfraMpr;

    @Autowired
    public EntryHistoryJpaAdpt(EntryHistoryJpaRepo entryHistoryJpaRepo) {

        this.entryHistoryJpaRepo = entryHistoryJpaRepo;
        paymentInfraMpr = new PaymentInfraMpr();
    }

    @Override
    public EntryHistoryAgg save(EntryHistoryAgg entryHistory) {


        EntryHistoryJpaEnt toEntity = paymentInfraMpr.entryHistory_to_entryHistoryEntity(entryHistory);

        entryHistoryJpaRepo.save(toEntity);

        return entryHistory;
    }

    @Override
    public List<EntryHistoryAgg> get_by_customerId(CustomerId customerId) {


        Optional<List<EntryHistoryJpaEnt>> entryHistory = entryHistoryJpaRepo.findByCustomerId(customerId.getValue());

        return entryHistory.map(entryList -> entryList.stream()
                                                      .map(paymentInfraMpr::entryHistoryEntity_to_entryHistory)
                                                      .collect(Collectors.toList()))
                           .orElseThrow(() -> new PayInfraExc(
                                   "Error when finding for a customer id to get the entry history"));

    }

}
