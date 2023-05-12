package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.domain.model.vo.MoneyVo;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;

import java.util.List;

public class ReservationAgg extends AggregateRoot<ReservationId> {

    private final CustomerId customerId;
    private final StationId stationId;
    private final MoneyVo price;
    private final TrackingId trackingId;
    private final ReservationStatus status;
    private final List<String> messageBox;
    List<ReservationItem> items;

    private ReservationAgg(Builder builder) {

        super.setId(builder.reservationId);
        customerId = builder.customerId;
        stationId = builder.stationId;
        price = builder.price;
        items = builder.items;
        trackingId = builder.trackingId;
        status = builder.status;
        messageBox = builder.messageBox;
    }

    //<editor-fold desc="--> Getter - Builder">
    public CustomerId getCustomerId() {

        return customerId;
    }

    public StationId getStationId() {

        return stationId;
    }

    public MoneyVo getPrice() {

        return price;
    }

    public List<ReservationItem> getItems() {

        return items;
    }

    public TrackingId getTrackingId() {

        return trackingId;
    }

    public ReservationStatus getStatus() {

        return status;
    }

    public List<String> getMessageBox() {

        return messageBox;
    }

    public static final class Builder {

        private CustomerId customerId;
        private StationId stationId;
        private MoneyVo price;
        private List<ReservationItem> items;
        private TrackingId trackingId;
        private ReservationStatus status;
        private List<String> messageBox;
        private ReservationId reservationId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder customerId(CustomerId val) {

            customerId = val;
            return this;
        }

        public Builder stationId(StationId val) {

            stationId = val;
            return this;
        }

        public Builder price(MoneyVo val) {

            price = val;
            return this;
        }

        public Builder items(List<ReservationItem> val) {

            items = val;
            return this;
        }

        public Builder trackingId(TrackingId val) {

            trackingId = val;
            return this;
        }

        public Builder status(ReservationStatus val) {

            status = val;
            return this;
        }

        public Builder messageBox(List<String> val) {

            messageBox = val;
            return this;
        }

        public Builder reservationId(ReservationId val) {

            reservationId = val;
            return this;
        }

        public ReservationAgg build() {

            return new ReservationAgg(this);
        }

    }
    //</editor-fold>

}
