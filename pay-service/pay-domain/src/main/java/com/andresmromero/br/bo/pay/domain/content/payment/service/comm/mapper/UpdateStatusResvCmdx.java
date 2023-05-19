package com.andresmromero.br.bo.pay.domain.content.payment.service.comm.mapper;

public class UpdateStatusResvCmdx {

    private String conditional;
    private String newStatus;

    public UpdateStatusResvCmdx() {

    }

    public UpdateStatusResvCmdx(String conditional, String newStatus) {

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
