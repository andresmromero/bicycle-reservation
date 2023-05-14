package com.andresmromero.br.bo.pay.application.context.payment.service.command.cancelled;

import lombok.Builder;

import java.util.List;

@Builder
public record CanceledPaymentRes(List<String> message) {

}
