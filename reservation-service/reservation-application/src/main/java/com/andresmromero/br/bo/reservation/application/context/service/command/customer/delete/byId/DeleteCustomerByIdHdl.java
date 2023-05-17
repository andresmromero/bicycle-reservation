package com.andresmromero.br.bo.reservation.application.context.service.command.customer.delete.byId;

import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.shared.annotation.ApplicationComp;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@ApplicationComp
@AllArgsConstructor
public class DeleteCustomerByIdHdl {

    private final DeleteByIdCustomer delete;

    @Transactional
    public void invoke(DeleteCustomerByIdCmd command) {

        delete.delete_by_id(new CustomerId(command.id()));
    }

}
