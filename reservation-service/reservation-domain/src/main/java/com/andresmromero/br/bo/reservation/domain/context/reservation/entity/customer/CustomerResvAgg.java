package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.EmailVo;

public class CustomerResvAgg extends AggregateRoot<CustomerId> {

    private final String name;
    private final String surname;
    private final String nickname;
    private final EmailVo email;

    private CustomerResvAgg(Builder builder) {

        super.setId(builder.customerId);
        name = builder.name;
        surname = builder.surname;
        nickname = builder.nickname;
        email = builder.email;
    }

    public String getName() {

        return name;
    }

    public String getSurname() {

        return surname;
    }

    public String getNickname() {

        return nickname;
    }

    public EmailVo getEmail() {

        return email;
    }

    public static final class Builder {

        private String name;
        private String surname;
        private String nickname;
        private EmailVo email;
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

        public Builder email(EmailVo val) {

            email = val;
            return this;
        }

        public Builder customerId(CustomerId val) {

            customerId = val;
            return this;
        }

        public CustomerResvAgg build() {

            return new CustomerResvAgg(this);
        }

    }

}
