package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;

public class CustomerAgg extends AggregateRoot<CustomerId> {

    private final String name;
    private final String surname;
    private final String nickname;

    private CustomerAgg(Builder builder) {

        super.setId(builder.customerId);
        name = builder.name;
        surname = builder.surname;
        nickname = builder.nickname;
    }


    public static final class Builder {

        private String name;
        private String surname;
        private String nickname;
        private CustomerId customerId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder name(String val) {

            name = val;
            return this;
        }

        public Builder surname(String val) {

            surname = val;
            return this;
        }

        public Builder nickname(String val) {

            nickname = val;
            return this;
        }

        public Builder customerId(CustomerId val) {

            customerId = val;
            return this;
        }

        public CustomerAgg build() {

            return new CustomerAgg(this);
        }

    }

}
