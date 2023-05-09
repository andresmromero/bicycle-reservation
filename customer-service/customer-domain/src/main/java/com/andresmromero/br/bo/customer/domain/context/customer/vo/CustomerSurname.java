package com.andresmromero.br.bo.customer.domain.context.customer.vo;

import com.andresmromero.br.bo.context.domain.vo.StringVo;

public class CustomerSurname extends StringVo {

    private final String value;

    public CustomerSurname(String value) {

        super(value);
        this.value = value;
    }

    public String getValue() {

        return value;
    }

}
