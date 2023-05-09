package com.andresmromero.br.bo.customer.domain.context.customer.model;

import com.andresmromero.br.bo.context.domain.model.AggregateRoot;
import com.andresmromero.br.bo.context.domain.vo.CellPhoneNumberVo;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.EmailVo;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerName;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerSurname;

public class CustomerAgg extends AggregateRoot<CustomerId> {

    private final CustomerName name;
    private final CustomerSurname surname;
    private final EmailVo email;
    private final CellPhoneNumberVo cellPhone;

    private CustomerAgg(Builder builder) {

        super.setId(builder.customerId);
        name = builder.name;
        surname = builder.surname;
        email = builder.email;
        cellPhone = builder.cellPhone;
    }

    public CustomerName getName() {

        return name;
    }

    public CustomerSurname getSurname() {

        return surname;
    }

    public EmailVo getEmail() {

        return email;
    }

    public CellPhoneNumberVo getCellPhone() {

        return cellPhone;
    }


    public static final class Builder {

        private CustomerName name;
        private CustomerSurname surname;
        private EmailVo email;
        private CellPhoneNumberVo cellPhone;
        private CustomerId customerId;

        private Builder() {

        }

        public static Builder builder() {

            return new Builder();
        }

        public Builder name(CustomerName val) {

            name = val;
            return this;
        }

        public Builder surname(CustomerSurname val) {

            surname = val;
            return this;
        }

        public Builder email(EmailVo val) {

            email = val;
            return this;
        }

        public Builder cellPhone(CellPhoneNumberVo val) {

            cellPhone = val;
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

