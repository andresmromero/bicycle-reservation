package com.andresmromero.br.bo.reservation.infrastructure.comm.context.service.pay.send;

import lombok.Builder;

import java.util.List;

@Builder
public record SendPayRes(List<String> message) {

}
