package com.andresmromero.br.bo.station.domain.context.station_reservation.model.station;

import com.andresmromero.br.bo.context.domain.model.BaseModel;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationReceivedId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationReceivedStatus;

public class ReservationReceivedStn extends BaseModel<ReservationReceivedId> {

    private final StationId stationId;
    private final ReservationId reservationId;
    private final ReservationReceivedStatus status;

    private ReservationReceivedStn(Builder builder) {

        super.setId(builder.reservationReceivedId);
        stationId = builder.stationId;
        reservationId = builder.reservationId;
        status = builder.status;
    }

    public StationId getStationId() {

        return stationId;
    }

    public ReservationId getReservationId() {

        return reservationId;
    }

    public ReservationReceivedStatus getStatus() {

        return status;
    }

    public static final class Builder {

        private ReservationReceivedId reservationReceivedId;
        private StationId stationId;
        private ReservationId reservationId;
        private ReservationReceivedStatus status;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder reservationReceivedId(ReservationReceivedId val) {

            reservationReceivedId = val;
            return this;
        }

        public Builder stationId(StationId val) {

            stationId = val;
            return this;
        }

        public Builder reservationId(ReservationId val) {

            reservationId = val;
            return this;
        }

        public Builder status(ReservationReceivedStatus val) {

            status = val;
            return this;
        }

        public ReservationReceivedStn build() {

            return new ReservationReceivedStn(this);
        }

    }

}
