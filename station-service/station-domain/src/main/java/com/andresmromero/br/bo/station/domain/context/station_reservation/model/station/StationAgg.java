package com.andresmromero.br.bo.station.domain.context.station_reservation.model.station;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;

public class StationAgg extends AggregateRoot<StationId> {

    private final ReservationDetailStn reservationDetail;
    private ReservationReceivedStn reservationReceived;
    private boolean isActive;

    private StationAgg(Builder builder) {

        super.setId(builder.stationId);
        reservationReceived = builder.reservationReceived;
        isActive = builder.isActive;
        reservationDetail = builder.reservationDetail;
    }


    public static final class Builder {

        private StationId stationId;
        private ReservationReceivedStn reservationReceived;
        private boolean isActive;
        private ReservationDetailStn reservationDetail;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder stationId(StationId val) {

            stationId = val;
            return this;
        }

        public Builder reservationReceived(ReservationReceivedStn val) {

            reservationReceived = val;
            return this;
        }

        public Builder isActive(boolean val) {

            isActive = val;
            return this;
        }

        public Builder reservationDetail(ReservationDetailStn val) {

            reservationDetail = val;
            return this;
        }

        public StationAgg build() {

            return new StationAgg(this);
        }

    }

}
