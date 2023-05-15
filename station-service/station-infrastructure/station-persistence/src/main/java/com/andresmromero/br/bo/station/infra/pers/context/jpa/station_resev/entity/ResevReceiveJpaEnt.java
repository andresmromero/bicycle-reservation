package com.andresmromero.br.bo.station.infra.pers.context.jpa.station_resev.entity;

import com.andresmromero.br.bo.context.domain.model.enums.ReservationReceivedStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation_receive")
@Entity
public class ResevReceiveJpaEnt {

    @Id
    private UUID id;
    private UUID stationId;
    private UUID reservationId;
    @Enumerated(EnumType.STRING)
    private ReservationReceivedStatus status;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ResevReceiveJpaEnt that = (ResevReceiveJpaEnt) o;
        return id.equals(that.id) && Objects.equals(stationId, that.stationId) &&
                Objects.equals(reservationId, that.reservationId) && status == that.status;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, stationId, reservationId, status);
    }

}

