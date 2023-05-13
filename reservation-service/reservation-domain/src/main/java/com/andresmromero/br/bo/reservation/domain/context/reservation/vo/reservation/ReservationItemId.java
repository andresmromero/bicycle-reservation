package com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.AttributeId;

import java.util.UUID;

public class ReservationItemId extends AttributeId<UUID> {

    public ReservationItemId(UUID value) {

        super(value);
    }

}
