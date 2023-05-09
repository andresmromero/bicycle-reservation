package com.andresmromero.br.bo.customer.application.context.customer.service.query.get.byId;


import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record GetCustomerByIdQry(@NotNull UUID id) {}
