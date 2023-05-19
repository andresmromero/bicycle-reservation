package com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.mapper;

import com.andresmromero.br.bo.context.domain.vo.CellPhoneNumberVo;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.EmailVo;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureComp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerName;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerSurname;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.entity.CustomerJpaEnt;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.exception.CustomerPersExc;

import java.util.Optional;

@InfrastructureComp
public class CustomerJpaMpr {

    public CustomerJpaEnt customer_to_customerEntity(CustomerAgg c) {

        return CustomerJpaEnt.builder()
                             .id(c.getId().getValue())
                             .name(c.getName().getValue())
                             .surname(c.getSurname().getValue())
                             .email(c.getEmail().getValue())
                             .customerCountryCode(c.getCellPhone().getCountryCode())
                             .customerLocalNumber(c.getCellPhone().getLocalNumber())
                             .build();

    }

    public CustomerAgg customerEntity_to_customer(CustomerJpaEnt c) {

        CellPhoneNumberVo cellPhone = new CellPhoneNumberVo(c.getCustomerCountryCode(), c.getCustomerLocalNumber());
        return CustomerAgg.Builder.builder()
                                  .customerId(new CustomerId(c.getId()))
                                  .name(new CustomerName(c.getName()))
                                  .surname(new CustomerSurname(c.getSurname()))
                                  .email(new EmailVo(c.getEmail()))
                                  .cellPhone(cellPhone)
                                  .build();
    }

    public CustomerJpaEnt map_entity_to_update_model(Optional<CustomerJpaEnt> found, CustomerAgg c) {

        found.orElseThrow(() -> new CustomerPersExc("exception thrown when client entity is not found"));
        CustomerJpaEnt customerFound = found.get();
        customerFound.setName(c.getName().getValue());
        customerFound.setSurname(c.getSurname().getValue());
        customerFound.setEmail(c.getEmail().getValue());
        customerFound.setCustomerLocalNumber(c.getCellPhone().getLocalNumber());
        customerFound.setCustomerCountryCode(c.getCellPhone().getCountryCode());
        return customerFound;

    }

}
