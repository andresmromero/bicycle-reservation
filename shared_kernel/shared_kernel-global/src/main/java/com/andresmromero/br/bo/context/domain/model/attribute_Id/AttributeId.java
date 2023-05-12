package com.andresmromero.br.bo.context.domain.model.attribute_Id;

import java.util.Objects;

public abstract class AttributeId<ID> {

    private final ID value;

    public AttributeId(ID value) {

        this.value = value;
    }

    public ID getValue() {

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
        AttributeId<?> that = (AttributeId<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(value);
    }

}
