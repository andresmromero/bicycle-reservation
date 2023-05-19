package com.andresmromero.br.bo.customer.infrastructure.persistence.context.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "customer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerJpaEnt {

    @Id
    private UUID id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String email;
    @Column
    private Integer customerCountryCode;
    @Column
    private Long customerLocalNumber;

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerJpaEnt that = (CustomerJpaEnt) o;
        return customerCountryCode == that.customerCountryCode && customerLocalNumber == that.customerLocalNumber &&
                id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, surname, email, customerCountryCode, customerLocalNumber);
    }

}
