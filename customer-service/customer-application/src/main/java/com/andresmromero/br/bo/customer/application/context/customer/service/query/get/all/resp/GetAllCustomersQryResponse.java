package com.andresmromero.br.bo.customer.application.context.customer.service.query.get.all.resp;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllCustomersQryResponse(@NotNull List<GetAllCustomerQryElem> customers) {}
