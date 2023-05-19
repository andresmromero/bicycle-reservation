package com.andresmromero.br.bo.customer.infrastructure.comm.context.http;

import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.CreateCustomerComm;
import com.andresmromero.br.bo.customer.domain.context.customer.service.comm.resv.UpdateResevCustomerByIdComm;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@FeignClient(name = "reservationservice")
public interface CustReservHttpRest {


    @PostMapping("/customer")
    void save_customer(@Valid @RequestBody CreateCustomerComm command);

    @PutMapping("/customer/{id}")
    void update_customer_by_id(@PathVariable("id") UUID id, @Valid @RequestBody UpdateResevCustomerByIdComm command);

    @DeleteMapping("/customer/{id}")
    void delete_customer_by_id(@PathVariable("id") UUID id);

}
