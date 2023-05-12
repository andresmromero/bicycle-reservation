package com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation;

import com.andresmromero.br.bo.context.domain.model.attribute_Id.AttributeId;

import java.util.UUID;

public class TrackingId extends AttributeId<UUID> {

    public TrackingId(UUID value) {

        super(value);
    }

}
