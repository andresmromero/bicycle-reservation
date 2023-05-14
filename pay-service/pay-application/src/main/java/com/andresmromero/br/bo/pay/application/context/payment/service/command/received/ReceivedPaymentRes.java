package com.andresmromero.br.bo.pay.application.context.payment.service.command.received;

import lombok.Builder;

import java.util.List;

@Builder
public record ReceivedPaymentRes(List<String> message) {

}
