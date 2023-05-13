package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationJpaEnt {

    @Id
    private UUID reservationId;

    private UUID customerId;

    private UUID stationId;

    private UUID trackingId;

    private String reservationStatus;

    private BigDecimal price;

    private String messagesBox;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ReservationJpaEnt that = (ReservationJpaEnt) o;
        return reservationId.equals(that.reservationId) && Objects.equals(customerId, that.customerId) &&
                Objects.equals(stationId, that.stationId) && Objects.equals(trackingId, that.trackingId) &&
                Objects.equals(reservationStatus, that.reservationStatus) && Objects.equals(price, that.price) &&
                Objects.equals(messagesBox, that.messagesBox);
    }

    @Override
    public int hashCode() {

        return Objects.hash(reservationId, customerId, stationId, trackingId, reservationStatus, price, messagesBox);
    }

}
