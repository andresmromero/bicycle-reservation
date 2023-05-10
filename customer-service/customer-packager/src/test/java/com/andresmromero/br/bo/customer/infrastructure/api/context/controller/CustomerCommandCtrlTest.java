package com.andresmromero.br.bo.customer.infrastructure.api.context.controller;

import com.andresmromero.br.bo.customer.application.context.customer.service.command.CustomerCmdAdpt;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.create.CreateCustomerCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId.DeleteCustomerByIdCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId.UpdateCustomerByIdCmd;
import com.andresmromero.br.bo.customer.packager.CustomerPackagerApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.UUID;

import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CustomerPackagerApplication.class})
@AutoConfigureMockMvc
class CustomerCommandCtrlTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CustomerCmdAdpt adapter;
    @Autowired
    private ObjectMapper objectMapper;
    private CreateCustomerCmd command;
    private UUID commandId;
    private UpdateCustomerByIdCmd commandUpdated;

    @BeforeEach
    void setUp() {

        objectMapper = new ObjectMapper();
        commandId = UUID.randomUUID();
        command = CreateCustomerCmd.builder()
                                   .id(commandId)
                                   .name("any-name")
                                   .surname("any-surname")
                                   .email("any_email@gmail.com")
                                   .customerCountryCode(57)
                                   .customerLocalNumber(3209114788L)
                                   .build();

        commandUpdated = UpdateCustomerByIdCmd.builder()
                                              .id(commandId)
                                              .name("name-updated")
                                              .surname("surname-updated")
                                              .email("emailupdated@gmail.com")
                                              .customerCountryCode(58)
                                              .customerLocalNumber(3229114789L)
                                              .build();
    }

    @Test
    void save_customer() throws Exception {

        willDoNothing().given(adapter).save_customer(command);

        ResultActions resultActions = mockMvc.perform(request(HttpMethod.valueOf("POST"),
                                                              "/").content(String.valueOf(objectMapper.writeValueAsString(
                command))).contentType(APPLICATION_JSON));

        resultActions.andExpect(status().is(201));

    }

    @Test
    void update_customer_by_id() throws Exception {

        willDoNothing().given(adapter).update_customer_by_id(commandUpdated);


        ResultActions resultActions = mockMvc.perform(put("/{id}", commandId).contentType(APPLICATION_JSON)
                                                                             .content(objectMapper.writeValueAsString(
                                                                                     commandUpdated)));
        resultActions.andExpect(status().isOk());

    }

    @Test
    void delete_customer_by_id() throws Exception {

        willDoNothing().given(adapter).delete_customer_by_id(new DeleteCustomerByIdCmd(commandId));

        ResultActions resultActions = mockMvc.perform(delete("/{id}", commandId));

        resultActions.andExpect(status().isNoContent());
    }

}



