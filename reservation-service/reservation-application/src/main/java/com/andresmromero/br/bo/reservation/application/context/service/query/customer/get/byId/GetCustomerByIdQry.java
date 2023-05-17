package com.andresmromero.br.bo.reservation.application.context.service.query.customer.get.byId;


import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record GetCustomerByIdQry(@NotNull UUID id) {}
