package com.andresmromero.br.bo.pay.domain.content.payment.repository.persistence;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.pay.domain.content.payment.model.payment.EntryAgg;

import java.util.Optional;

public interface EntryPersSvc {

    EntryAgg save(EntryAgg entry);

    Optional<EntryAgg> get_by_customerId(CustomerId customerId);

}
