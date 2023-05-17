package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.adapter;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.InfrastructureSvc;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.customer.CustomerResvAgg;
import com.andresmromero.br.bo.reservation.domain.context.reservation.repository.persistence.CustomerResvPersSvc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity.CustomerResvJpaEnt;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.exception.ResvInfraExc;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.mapper.ResvInfraJpaMpr;
import com.andresmromero.br.bo.reservation.infra.pers.context.jpa.repository.CustomerResvJpaRepo;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@InfrastructureSvc
@AllArgsConstructor
public class CustomerJpaAdpt implements CustomerResvPersSvc {

    private final CustomerResvJpaRepo customerJpaRepo;
    private final ResvInfraJpaMpr infraJpaMpr;

    @Override
    public Optional<CustomerResvAgg> get_customer_id(CustomerId customerId) {

        UUID id = customerId.getValue();
        return Optional.of(customerJpaRepo.findById(id)
                                          .map(infraJpaMpr::customerEntity_to_customer)
                                          .orElseThrow(() -> new ResvInfraExc("Error when finding for customer id")));
    }

    @Override
    public CustomerResvAgg save(CustomerResvAgg customer) {


        Optional<CustomerResvJpaEnt> isExist = customerJpaRepo.findById(customer.getId().getValue());

        if (isExist.isPresent()) {
            throw new ResvInfraExc("Exception thrown on finding the client id of the client to be saved");
        }


        CustomerResvJpaEnt customerEntity = infraJpaMpr.customer_to_customerEntity(customer);
        CustomerResvJpaEnt saved = customerJpaRepo.save(customerEntity);
        return infraJpaMpr.customerEntity_to_customer(customerEntity);

    }

    @Override
    public void delete_by_id(CustomerId customerId) {

        customerJpaRepo.deleteById(customerId.getValue());

    }

    @Override
    public CustomerResvAgg update_by_id(CustomerResvAgg customer) {

        Optional<CustomerResvJpaEnt> find = Optional.of(customerJpaRepo.findById(customer.getId().getValue())
                                                                       .orElseThrow(() -> new ResvInfraExc(
                                                                               "Exception thrown when finding for an id to update")));

        CustomerResvJpaEnt customerJpa = infraJpaMpr.map_entity_to_update_model_customer(find, customer);
        customerJpaRepo.save(customerJpa);
        return infraJpaMpr.customerEntity_to_customer(customerJpa);

    }

    @Override
    public List<CustomerResvAgg> get_all_customer() {

        return customerJpaRepo.findAll().stream().map(infraJpaMpr::customerEntity_to_customer).toList();
    }

    @Override
    public Optional<CustomerResvAgg> get_customer_by_id(CustomerId customerId) {


        return Optional.of(customerJpaRepo.findById(customerId.getValue())
                                          .map(infraJpaMpr::customerEntity_to_customer)
                                          .orElseThrow(() -> new ResvInfraExc(
                                                  "Exception thrown when getting a client in persistence")));
    }

}
