package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "entry")
@Entity
public class EntryJpaEnt {

    @Id
    private UUID id;
    private UUID customerId;
    private BigDecimal totalEntry;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntryJpaEnt that = (EntryJpaEnt) o;
        return id.equals(that.id) && Objects.equals(customerId, that.customerId) &&
                Objects.equals(totalEntry, that.totalEntry);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customerId, totalEntry);
    }

}
