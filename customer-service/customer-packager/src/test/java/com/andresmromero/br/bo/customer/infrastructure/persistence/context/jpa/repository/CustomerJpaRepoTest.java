package com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.repository;

import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.entity.CustomerJpaEnt;
import com.andresmromero.br.bo.customer.packager.CustomerPackagerApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = {CustomerPackagerApplication.class})
class CustomerJpaRepoTest {

    @Autowired
    private CustomerJpaRepo repository;

    @Test
    void save() {

        CustomerJpaEnt entity = CustomerJpaEnt.builder()
                                              .id("f17ce5dd-c3ae-408a-a973-3cd8c89704c9")
                                              .email("any_email")
                                              .surname("any-surname")
                                              .name("any-name")
                                              .customerLocalNumber(3220911922L)
                                              .customerCountryCode(57)
                                              .build();
        CustomerJpaEnt saved = repository.save(entity);
        assertNotNull(saved);
    }

    @Test
    void delete_by_id() {

        CustomerJpaEnt entity = CustomerJpaEnt.builder()
                                              .id("f17ce5dd-c3ae-408a-a973-3cd8c89704c9")
                                              .email("any_email")
                                              .surname("any-surname")
                                              .name("any-name")
                                              .customerLocalNumber(3220911922L)
                                              .customerCountryCode(57)
                                              .build();
        CustomerJpaEnt saved = repository.save(entity);

        repository.deleteById(entity.getId());

        Optional<CustomerJpaEnt> find = repository.findById(entity.getId());

        assertEquals(find, Optional.empty());
    }

    @Test
    void get_all_customer() {

        CustomerJpaEnt firstEntity = CustomerJpaEnt.builder()
                                                   .id("f17ce5dd-c3ae-408a-a973-3cd8c89704c9")
                                                   .email("any_email")
                                                   .surname("any-surname")
                                                   .name("any-name")
                                                   .customerLocalNumber(3220911922L)
                                                   .customerCountryCode(57)
                                                   .build();
        CustomerJpaEnt secondEntity = CustomerJpaEnt.builder()
                                                    .id("f17ce5dd-c3ae-408a-a973-3cd8c89704c7")
                                                    .email("any_email")
                                                    .surname("any-surname")
                                                    .name("any-name")
                                                    .customerLocalNumber(3214776288L)
                                                    .customerCountryCode(58)
                                                    .build();
        repository.save(firstEntity);
        repository.save(secondEntity);

        List<CustomerJpaEnt> customerJpaList = repository.findAll();

        assertNotNull(customerJpaList);
        assertEquals(customerJpaList.size(), 2);
    }

}