package com.andresmromero.br.bo.context.domain.vo;

import java.util.Objects;

public abstract class IntVo {

    private final int value;

    public IntVo(int value) {

        this.value = value;
    }

    public int getValue() {

        return value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IntVo intVo = (IntVo) o;
        return value == intVo.value;
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

    @Override
    public String toString() {

        return "IntVo{" + "value=" + value + '}';
    }

}
