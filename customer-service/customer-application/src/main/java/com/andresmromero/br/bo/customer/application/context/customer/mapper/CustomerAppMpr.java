package com.andresmromero.br.bo.customer.application.context.customer.mapper;

import com.andresmromero.br.bo.context.domain.vo.CellPhoneNumberVo;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.EmailVo;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.create.CreateCustomerCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId.UpdateCustomerByIdCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomerQryElem;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerName;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerSurname;

import java.util.List;
import java.util.function.Function;

@ApplicationComp
public class CustomerAppMpr {

    private static Function<CustomerAgg, GetAllCustomerQryElem> mapper_customerItem_to_GetAllCustomerQryElemItem() {

        return c -> GetAllCustomerQryElem.builder()
                                         .id(c.getId().getValue())
                                         .name(c.getName().getValue())
                                         .surname(c.getSurname().getValue())
                                         .email(c.getEmail().getValue())
                                         .customerCountryCode(c.getCellPhone().getCountryCode())
                                         .customerLocalNumber(c.getCellPhone().getLocalNumber())
                                         .build();
    }

    public CustomerAgg createCustomerCmd_to_customer(CreateCustomerCmd c) {

        CellPhoneNumberVo cellPhone = new CellPhoneNumberVo(c.customerCountryCode(), c.customerLocalNumber());

        return CustomerAgg.Builder.builder()
                                  .customerId(new CustomerId(c.id()))
                                  .name(new CustomerName(c.name()))
                                  .surname(new CustomerSurname(c.surname()))
                                  .email(new EmailVo(c.email()))
                                  .cellPhone(cellPhone)
                                  .build();

    }

    public GetAllCustomersQryResponse customer_to_getAllCustomerQryResponse(List<CustomerAgg> customer) {

        List<GetAllCustomerQryElem> elements =
                customer.stream().map(mapper_customerItem_to_GetAllCustomerQryElemItem()).toList();

        return GetAllCustomersQryResponse.builder().customers(elements).build();
    }


    public GetCustomerByIdQryResp customer_to_getByIdCustomerQryResp(CustomerAgg c) {

        return GetCustomerByIdQryResp.builder()
                                     .id(c.getId().getValue())
                                     .name(c.getName().getValue())
                                     .surname(c.getSurname().getValue())
                                     .email(c.getEmail().getValue())
                                     .customerCountryCode(c.getCellPhone().getCountryCode())
                                     .customerLocalNumber(c.getCellPhone().getLocalNumber())
                                     .build();

    }

    public CustomerAgg updateCustomerCmd_to_customer(UpdateCustomerByIdCmd c) {

        CellPhoneNumberVo cellPhone = new CellPhoneNumberVo(c.customerCountryCode(), c.customerLocalNumber());

        return CustomerAgg.Builder.builder()
                                  .customerId(new CustomerId(c.id()))
                                  .name(new CustomerName(c.name()))
                                  .surname(new CustomerSurname(c.surname()))
                                  .email(new EmailVo(c.email()))
                                  .cellPhone(cellPhone)
                                  .build();
    }

}
