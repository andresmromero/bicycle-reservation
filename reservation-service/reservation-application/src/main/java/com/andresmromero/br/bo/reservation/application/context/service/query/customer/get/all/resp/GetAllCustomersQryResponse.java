package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.all.resp;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;

@Builder
public record GetAllCustomersQryResponse(@NotNull List<GetAllCustomerQryElem> customers) {}
