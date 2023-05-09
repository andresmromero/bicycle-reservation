package com.andresmromero.br.bo.customer.infrastructure.api.context.controller;

import com.andresmromero.br.bo.customer.application.context.customer.service.query.CustomerQryAdpt;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.GetCustomerByIdQry;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.resp.GetCustomerByIdQryResp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerQueryCtrl {

    private final CustomerQryAdpt customerQryAdapter;

    @GetMapping("/health-check-query")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "customer-query");
        status.put("status", "ok");
        return status;
    }

    @GetMapping("/")
    public ResponseEntity<?> get_all_customer() {

        GetAllCustomersQryResponse resp = customerQryAdapter.get_all_customers();
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCustomerByIdQryResp> get_customer_by_id(@PathVariable("id") UUID id) {

        GetCustomerByIdQryResp resp = customerQryAdapter.get_customer_by_id(new GetCustomerByIdQry(id));
        return ResponseEntity.status(HttpStatus.OK).body(resp);
    }

}
