package com.andresmromero.br.bo.customer.infrastructure.api.context.controller;

import com.andresmromero.br.bo.customer.application.context.customer.service.command.CustomerCmdAdpt;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.create.CreateCustomerCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.delete.byId.DeleteCustomerByIdCmd;
import com.andresmromero.br.bo.customer.application.context.customer.service.command.update.byId.UpdateCustomerByIdCmd;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class CustomerCommandCtrl {

    @Autowired
    private final CustomerCmdAdpt customerAdapter;

    @GetMapping("/health-check-command")
    public HashMap<String, String> index() {

        HashMap<String, String> status = new HashMap<>();
        status.put("application", "customer-command");
        status.put("status", "ok");
        return status;
    }

    @PostMapping("/")
    public ResponseEntity<?> save_customer(@Valid @RequestBody CreateCustomerCmd command) {

        customerAdapter.save_customer(command);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update_customer_by_id(@PathVariable("id") UUID id,
                                                   @Valid @RequestBody UpdateCustomerByIdCmd command) {

        customerAdapter.update_customer_by_id(command.withId(id));
        return ResponseEntity.status(HttpStatus.OK).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete_customer_by_id(@PathVariable("id") UUID id) {

        customerAdapter.delete_customer_by_id(new DeleteCustomerByIdCmd(id));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
