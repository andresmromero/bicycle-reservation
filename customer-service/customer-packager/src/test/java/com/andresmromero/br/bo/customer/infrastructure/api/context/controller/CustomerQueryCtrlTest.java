package com.andresmromero.br.bo.customer.infrastructure.api.context.controller;

import com.andresmromero.br.bo.customer.application.context.customer.service.query.CustomerQryAdpt;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomerQryElem;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.GetCustomerByIdQry;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.resp.GetCustomerByIdQryResp;
import com.andresmromero.br.bo.customer.packager.CustomerPackagerApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomerPackagerApplication.class})
@AutoConfigureMockMvc
public class CustomerQueryCtrlTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerQryAdpt adapter;

    @Autowired
    private ObjectMapper objectMapper;

    private UUID commandId;

    private GetCustomerByIdQryResp getCustomerByIdQryResp;


    private GetCustomerByIdQry getCustomerByIdQry;


    @Before
    public void setUp() throws Exception {

        commandId = UUID.randomUUID();
        objectMapper = new ObjectMapper();
        getCustomerByIdQry = new GetCustomerByIdQry(commandId);
        getCustomerByIdQryResp = GetCustomerByIdQryResp.builder()
                                                       .id(commandId)
                                                       .name("any-name")
                                                       .surname("any-surname")
                                                       .email("any_email@gmail.com")
                                                       .customerCountryCode(57)
                                                       .customerLocalNumber(3209114788L)
                                                       .build();
    }

    @Test
    public void get_customer_by_id() throws Exception {

        given(adapter.get_customer_by_id(getCustomerByIdQry)).willReturn(getCustomerByIdQryResp);

        ResultActions resultActions = mockMvc.perform(get("/{id}", commandId));

        resultActions.andExpect(status().isOk())
                     .andExpect(jsonPath("$.name").value(getCustomerByIdQryResp.name()))
                     .andExpect(jsonPath("$.surname").value(getCustomerByIdQryResp.surname()))
                     .andExpect(jsonPath("$.email").value(getCustomerByIdQryResp.email()))
                     .andExpect(jsonPath("$.customerLocalNumber").value(getCustomerByIdQryResp.customerLocalNumber()))
                     .andExpect(jsonPath("$.customerCountryCode").value(getCustomerByIdQryResp.customerCountryCode()));

    }

    @Test
    public void get_all_customer() throws Exception {

        GetAllCustomerQryElem firstElement = GetAllCustomerQryElem.builder()
                                                                  .id(commandId)
                                                                  .name("first-name")
                                                                  .surname("first-surname")
                                                                  .email("first_email@gmail.com")
                                                                  .customerCountryCode(20)
                                                                  .customerLocalNumber(3201114788L)
                                                                  .build();
        GetAllCustomerQryElem secondElement = GetAllCustomerQryElem.builder()
                                                                   .id(commandId)
                                                                   .name("second-name")
                                                                   .surname("second-surname")
                                                                   .email("second_email@gmail.com")
                                                                   .customerCountryCode(22)
                                                                   .customerLocalNumber(3202224788L)
                                                                   .build();
        List<GetAllCustomerQryElem> elements = List.of(firstElement, secondElement);
        GetAllCustomersQryResponse responseElements = GetAllCustomersQryResponse.builder().customers(elements).build();

        given(adapter.get_all_customers()).willReturn(responseElements);

        ResultActions resultActions = mockMvc.perform(get("/"));

        resultActions.andExpect(status().isOk())
                     .andExpect(jsonPath("$.customers.size()", is(responseElements.customers().size())));
    }

}