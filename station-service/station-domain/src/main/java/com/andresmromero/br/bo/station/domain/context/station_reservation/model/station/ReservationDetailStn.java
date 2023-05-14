package com.andresmromero.br.bo.station.domain.context.station_reservation.model.station;

import com.andresmromero.br.bo.context.domain.model.BaseModel;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationDetailId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;

import java.util.List;

public class ReservationDetailStn extends BaseModel<ReservationDetailId> {

    private final List<VehicleStn> vehicleList;
    private ReservationStatus status;
    private MoneyVo total;

    private ReservationDetailStn(Builder builder) {

        super.setId(builder.reservationDetailId);
        vehicleList = builder.vehicleList;
        status = builder.status;
        total = builder.total;
    }


    public static final class Builder {

        private ReservationDetailId reservationDetailId;
        private List<VehicleStn> vehicleList;
        private ReservationStatus status;
        private MoneyVo total;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder reservationDetailId(ReservationDetailId val) {

            reservationDetailId = val;
            return this;
        }

        public Builder vehicleList(List<VehicleStn> val) {

            vehicleList = val;
            return this;
        }

        public Builder status(ReservationStatus val) {

            status = val;
            return this;
        }

        public Builder total(MoneyVo val) {

            total = val;
            return this;
        }

        public ReservationDetailStn build() {

            return new ReservationDetailStn(this);
        }

    }

}
