package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity;

import com.andresmromero.br.bo.context.domain.model.enums.TransactionType;
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
@Table(name = "entry_history")
@Entity
public class EntryHistoryJpaEnt {


    @Id
    private UUID entryHistoryId;
    private UUID customerId;
    private BigDecimal total;
    private TransactionType type;


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EntryHistoryJpaEnt that = (EntryHistoryJpaEnt) o;
        return entryHistoryId.equals(that.entryHistoryId) && Objects.equals(customerId, that.customerId) &&
                Objects.equals(total, that.total) && type == that.type;
    }

    @Override
    public int hashCode() {

        return Objects.hash(entryHistoryId, customerId, total, type);
    }

}
