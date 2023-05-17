package com.andresmromero.br.bo.customer.application.context.customer.service.query;

import com.andresmromero.br.bo.context.shared.annotation.ApplicationSvc;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.GetAllCustomerHdl;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.GetCustomerByIdHdl;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.GetCustomerByIdQry;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.resp.GetCustomerByIdQryResp;
import lombok.AllArgsConstructor;

@ApplicationSvc
@AllArgsConstructor
public class CustomerQryAdpt implements CustomerQrySvc {

    private final GetAllCustomerHdl getAllCustomerHandler;
    private final GetCustomerByIdHdl getCustomerByIdHandler;

    @Override
    public GetAllCustomersQryResponse get_all_customers() {

        return getAllCustomerHandler.invoke();
    }

    @Override
    public GetCustomerByIdQryResp get_customer_by_id(GetCustomerByIdQry query) {

        return getCustomerByIdHandler.invoke(query);
    }

}
