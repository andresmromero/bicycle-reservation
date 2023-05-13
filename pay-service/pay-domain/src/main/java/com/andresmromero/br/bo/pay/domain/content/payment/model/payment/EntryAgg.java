package com.andresmromero.br.bo.pay.domain.content.payment.model.payment;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.EntryId;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;

public class EntryAgg extends AggregateRoot<EntryId> {

    private final CustomerId customerId;
    private MoneyVo total;

    private EntryAgg(Builder builder) {

        super.setId(builder.entryId);
        customerId = builder.customerId;
        total = builder.total;
    }


    public static final class Builder {

        private CustomerId customerId;
        private MoneyVo total;
        private EntryId entryId;

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

        public Builder id(EntryId val) {

            entryId = val;
            return this;
        }

        public EntryAgg build() {

            return new EntryAgg(this);
        }

    }

}
