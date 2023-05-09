package com.andresmromero.br.bo.context.domain.model;

public abstract class DomainExc extends RuntimeException {

    public DomainExc(String message) {

        super(message);
    }

}
