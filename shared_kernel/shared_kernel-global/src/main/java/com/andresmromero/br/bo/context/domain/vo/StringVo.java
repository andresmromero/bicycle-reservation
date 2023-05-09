package com.andresmromero.br.bo.context.domain.vo;

import java.util.Objects;

public abstract class StringVo {

    private String value;

    public StringVo(String value) {

        this.value = value;
    }

    @Override
    public String toString() {

        return "StringVo{" + "value='" + value + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StringVo stringVo = (StringVo) o;
        return Objects.equals(value, stringVo.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

}
