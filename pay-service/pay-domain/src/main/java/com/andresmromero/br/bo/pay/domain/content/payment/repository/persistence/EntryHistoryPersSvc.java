package com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryHistoryAgg;

import java.util.List;

public interface EntryHistoryPersSvc {

    EntryHistoryAgg save(EntryHistoryAgg entryHistory);

    List<EntryHistoryAgg> get_by_customerId(CustomerId customerId);

}
