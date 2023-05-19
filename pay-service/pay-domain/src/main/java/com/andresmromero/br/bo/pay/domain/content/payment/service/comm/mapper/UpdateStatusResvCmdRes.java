package com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper;

import java.util.List;

public record UpdateStatusResvCmdRes(List<String> message) {

    public UpdateStatusResvCmdRes(List<String> message) {

        this.message = message;
    }

}
