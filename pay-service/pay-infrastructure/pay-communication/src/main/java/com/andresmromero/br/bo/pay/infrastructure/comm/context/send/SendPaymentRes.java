package com.andresmromero.br.bo.pay.infrastructure.comm.context.send;

import lombok.Builder;

import java.util.List;

@Builder
public record SendPaymentRes(List<String> message) {

}
