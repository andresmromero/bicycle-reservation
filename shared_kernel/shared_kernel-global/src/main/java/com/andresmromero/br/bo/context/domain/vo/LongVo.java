package com.andresmromero.br.bo.context.domain.vo;

import java.util.Objects;

public abstract class LongVo {

    private Long value;

    public LongVo(Long value) {

        this.value = value;
    }

    public Long getValue() {

        return value;
    }

    public void setValue(Long value) {

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LongVo longVo = (LongVo) o;
        return Objects.equals(value, longVo.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

}
