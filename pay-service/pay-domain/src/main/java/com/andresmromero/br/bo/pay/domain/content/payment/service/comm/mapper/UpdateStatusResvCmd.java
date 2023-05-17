package com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper;

public class UpdateStatusResvCmd {

    private String conditional;
    private String newStatus;

    public UpdateStatusResvCmd(String conditional, String newStatus) {

        this.conditional = conditional;
        this.newStatus = newStatus;
    }

    public String getConditional() {

        return conditional;
    }

    public void setConditional(String conditional) {

        this.conditional = conditional;
    }

    public String getNewStatus() {

        return newStatus;
    }

    public void setNewStatus(String newStatus) {

        this.newStatus = newStatus;
    }

}
