package com.andresmromero.br.bo.customer.application.context.customer.service.query;

import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp.GetAllCustomersQryResponse;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.GetCustomerByIdQry;
import com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId.resp.GetCustomerByIdQryResp;

public interface CustomerQrySvc {

    GetAllCustomersQryResponse get_all_customers();

    GetCustomerByIdQryResp get_customer_by_id(GetCustomerByIdQry query);

}
