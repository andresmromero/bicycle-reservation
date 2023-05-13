package com.andresmromero.br.bo.reservation.infra.pers.context.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "customers")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResvJpaEnt {

    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String nickname;
    @Column
    private String email;


    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerResvJpaEnt that = (CustomerResvJpaEnt) o;
        return id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) &&
                Objects.equals(nickname, that.nickname) && Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, nickname, email);
    }

}