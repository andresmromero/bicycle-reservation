package com.andresmromero.br.bo.pay.infrastructure.persistence.context.payment.jpa.entity;

import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
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
@Table(name = "payment")
@Entity
public class PaymentJpaEnt {

    @Id
    private UUID id;
    private UUID customerId;
    private UUID reservationId;
    private BigDecimal price;
    private PaymentStatus status;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentJpaEnt that = (PaymentJpaEnt) o;
        return id.equals(that.id) && Objects.equals(customerId, that.customerId) &&
                Objects.equals(reservationId, that.reservationId) && Objects.equals(price, that.price) &&
                status == that.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customerId, reservationId, price, status);
    }

}
