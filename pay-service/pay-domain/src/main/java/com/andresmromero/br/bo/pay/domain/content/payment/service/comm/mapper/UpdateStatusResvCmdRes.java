package com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper;

import java.util.List;

public class UpdateStatusResvCmdRes {

    private List<String> message;

    public UpdateStatusResvCmdRes(List<String> message) {

        this.message = message;
    }

    public List<String> getMessage() {

        return message;
    }

    public void setMessage(List<String> message) {

        this.message = message;
    }

}
