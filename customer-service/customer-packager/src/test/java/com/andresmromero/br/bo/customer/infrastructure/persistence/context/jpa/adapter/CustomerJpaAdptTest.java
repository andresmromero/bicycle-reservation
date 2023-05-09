package com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.adapter;

import com.andresmromero.br.bo.context.domain.vo.CellPhoneNumberVo;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.EmailVo;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerName;
import com.andresmromero.br.bo.customer.domain.context.customer.vo.CustomerSurname;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.entity.CustomerJpaEnt;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.exception.CustomerPersExc;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.mapper.CustomerJpaMpr;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.repository.CustomerJpaRepo;
import com.andresmromero.br.bo.customer.packager.CustomerPackagerApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {CustomerPackagerApplication.class})
@RunWith(MockitoJUnitRunner.class)
class CustomerJpaAdptTest {

    @Mock
    private CustomerJpaRepo repository;
    @InjectMocks
    private CustomerJpaAdpt adapter;
    private CustomerAgg firstModel;
    private CustomerAgg secondModel;
    private CustomerJpaEnt firstEntity;
    private CustomerJpaEnt secondEntity;


    @BeforeEach
    void setup() {

        firstModel = CustomerAgg.Builder.builder()
                                        .customerId(new CustomerId(UUID.fromString(
                                                "2a61e958-7e37-4e8a-971b-9f1f8bf90e49")))
                                        .name(new CustomerName("first-name"))
                                        .surname(new CustomerSurname("first-surname"))
                                        .email(new EmailVo("first-name@mail.com"))
                                        .cellPhone(new CellPhoneNumberVo(12, 3209117844L))
                                        .build();

        firstEntity = CustomerJpaEnt.builder()
                                    .id("2a61e958-7e37-4e8a-971b-9f1f8bf90e49")
                                    .name("first-name")
                                    .surname("first-surname")
                                    .email("first-name@mail.com")
                                    .customerCountryCode(12)
                                    .customerLocalNumber(3209117844L)
                                    .build();

        secondModel = CustomerAgg.Builder.builder()
                                         .customerId(new CustomerId(UUID.fromString(
                                                 "218290e0-4d84-4581-82d2-43b3e6866387")))
                                         .name(new CustomerName("second-name"))
                                         .surname(new CustomerSurname("second-surname"))
                                         .email(new EmailVo("second-name@mail.com"))
                                         .cellPhone(new CellPhoneNumberVo(11, 3202347844L))
                                         .build();

        secondEntity = CustomerJpaEnt.builder()
                                     .id("218290e0-4d84-4581-82d2-43b3e6866387")
                                     .name("second-name")
                                     .surname("second-surname")
                                     .email("second-name@mail.com")
                                     .customerCountryCode(11)
                                     .customerLocalNumber(3202347844L)
                                     .build();
    }


    @Test
    void save() {

        String secondModelId = secondModel.getId().getValue().toString();
        given(repository.findById(secondModelId)).willReturn(Optional.empty());
        given(repository.save(secondEntity)).willReturn(secondEntity);

        CustomerAgg adapterResponse = adapter.save(secondModel);

        assertNotNull(adapterResponse);
        assertEquals(secondModel.getId().toString(), adapterResponse.getId().toString());
    }

    @Test
    void save_with_exception() {

        String secondModelId = secondModel.getId().getValue().toString();
        given(repository.findById(secondModelId)).willReturn(Optional.of(secondEntity));

        assertThrows(CustomerPersExc.class, () -> {
            adapter.save(secondModel);
        });

        verify(repository, never()).save(any(CustomerJpaEnt.class));
    }

    @Test
    void get_all_customer() {

        List<CustomerJpaEnt> entityList = List.of(firstEntity, secondEntity);
        given(repository.findAll()).willReturn(entityList);

        List<CustomerAgg> serviceResponse = adapter.get_all_customer();

        assertNotNull(serviceResponse);
        assertEquals(2, serviceResponse.size());
    }

    @Test
    void get_customer_empty_list() {

        when(repository.findAll()).thenReturn(Collections.emptyList());

        List<CustomerAgg> serviceResponse = adapter.get_all_customer();

        assertNotNull(serviceResponse);
        assertEquals(0, serviceResponse.size());
    }

    @Test
    void get_customer_by_id() {

        given(repository.findById(firstEntity.getId())).willReturn(Optional.of(firstEntity));

        CustomerAgg adapterResponse = adapter.get_customer_by_id(firstModel.getId()).get();

        assertNotNull(adapterResponse);
    }

    @Test
    void update_by_id() {

        String newName = "update-newName";
        String newSurname = "update-newSurname";
        given(repository.findById(firstModel.getId().getValue().toString())).willReturn(Optional.of(firstEntity));
        given(repository.save(firstEntity)).willReturn(firstEntity);
        firstEntity.setName(newName);
        firstEntity.setSurname(newSurname);

        CustomerAgg modelUpdated = new CustomerJpaMpr().customerEntity_to_customer(firstEntity);
        CustomerAgg adapterResponse = adapter.update_by_id(modelUpdated);

        assertEquals(adapterResponse.getName().getValue(), newName);
        assertEquals(adapterResponse.getSurname().getValue(), newSurname);

    }

    @Test
    void delete_by_id() {

        String modelId = firstModel.getId().getValue().toString();
        willDoNothing().given(repository).deleteById(modelId);

        adapter.delete_by_id(firstModel.getId());
        verify(repository, times(1)).deleteById(modelId);

    }

}