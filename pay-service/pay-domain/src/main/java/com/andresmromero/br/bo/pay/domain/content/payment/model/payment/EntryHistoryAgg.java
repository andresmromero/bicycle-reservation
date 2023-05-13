package com.andresmromero.br.bo.pay.domain.content.payment.model.payment;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.EntryHistoryId;
import com.andresmromero.br.bo.context.domain.model.enums.TransactionType;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;

public class EntryHistoryAgg extends AggregateRoot<EntryHistoryId> {

    private final CustomerId customerId;
    private final MoneyVo total;
    private final TransactionType transactionType;

    private EntryHistoryAgg(Builder builder) {

        super.setId(builder.entryHistoryId);
        customerId = builder.customerId;
        total = builder.total;
        transactionType = builder.transactionType;
    }

    public CustomerId getCustomerId() {

        return customerId;
    }

    public MoneyVo getTotal() {

        return total;
    }

    public TransactionType getTransactionType() {

        return transactionType;
    }

    public static final class Builder {

        private CustomerId customerId;
        private MoneyVo total;
        private TransactionType transactionType;
        private EntryHistoryId entryHistoryId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder customerId(CustomerId val) {

            customerId = val;
            return this;
        }

        public Builder total(MoneyVo val) {

            total = val;
            return this;
        }

        public Builder transactionType(TransactionType val) {

            transactionType = val;
            return this;
        }

        public Builder id(EntryHistoryId val) {

            entryHistoryId = val;
            return this;
        }

        public EntryHistoryAgg build() {

            return new EntryHistoryAgg(this);
        }

    }

}
