package com.andresmromero.br.bo.context.domain.model;

import java.util.Objects;

public abstract class BaseModel<ID> {

    private ID id;

    public ID getId() {

        return id;
    }

    public void setId(ID id) {

        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseModel<?> baseModel = (BaseModel<?>) o;
        return id.equals(baseModel.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

}
