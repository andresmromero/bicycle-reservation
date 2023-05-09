package com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.adapter;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.customer.domain.context.customer.model.CustomerAgg;
import com.andresmromero.br.bo.customer.domain.context.customer.repository.CustomerSvc;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.entity.CustomerJpaEnt;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.exception.CustomerPersExc;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.mapper.CustomerJpaMpr;
import com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.repository.CustomerJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@ApplicationSvc("CustomerJpaAdapter")
public class CustomerJpaAdpt implements CustomerSvc {

    private final CustomerJpaRepo customerRepository;
    private final CustomerJpaMpr customerMapper;

    @Autowired
    public CustomerJpaAdpt(CustomerJpaRepo customerRepository) {

        this.customerRepository = customerRepository;
        customerMapper = new CustomerJpaMpr();
    }

    @Override
    public CustomerAgg save(CustomerAgg customer) {


        Optional<CustomerJpaEnt> isExist = customerRepository.findById(customer.getId().getValue().toString());

        if (isExist.isPresent()) {
            throw new CustomerPersExc("Exception thrown on finding the client id of the client to be saved");
        }


        CustomerJpaEnt customerEntity = customerMapper.customer_to_customerEntity(customer);
        CustomerJpaEnt saved = customerRepository.save(customerEntity);
        return customerMapper.customerEntity_to_customer(customerEntity);

    }

    @Override
    public List<CustomerAgg> get_all_customer() {

        return customerRepository.findAll().stream().map(customerMapper::customerEntity_to_customer).toList();
    }

    @Override
    public Optional<CustomerAgg> get_customer_by_id(CustomerId customerId) {

        String customerIdOfEntity = customerId.getValue().toString();

        return Optional.of(customerRepository.findById(customerIdOfEntity)
                                             .map(customerMapper::customerEntity_to_customer)
                                             .orElseThrow(() -> new CustomerPersExc(
                                                     "Exception thrown when getting a client in persistence")));
    }

    @Override
    public CustomerAgg update_by_id(CustomerAgg customer) {

        Optional<CustomerJpaEnt> find = Optional.of(customerRepository.findById(customer.getId().getValue().toString())
                                                                      .orElseThrow(() -> new CustomerPersExc(
                                                                              "Exception thrown when finding for an id to update")));

        CustomerJpaEnt customerJpa = customerMapper.map_entity_to_update_model(find, customer);
        customerRepository.save(customerJpa);
        return customerMapper.customerEntity_to_customer(customerJpa);

    }

    @Override
    public void delete_by_id(CustomerId customerId) {

        customerRepository.deleteById(customerId.getValue().toString());
    }

}
