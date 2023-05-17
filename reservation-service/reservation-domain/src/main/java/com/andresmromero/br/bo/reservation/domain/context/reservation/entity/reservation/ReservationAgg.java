package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.ReservationItemId;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.TrackingId;

import java.util.List;
import java.util.UUID;

public class ReservationAgg extends AggregateRoot<ReservationId> {

    private final CustomerId customerId;
    private final StationId stationId;
    private final MoneyVo price;
    private final List<ReservationItem> items;
    private TrackingId trackingId;
    private ReservationStatus status;
    private List<String> messageBox;


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

    public void val_init_reservation(List<String> messageBox) {


        if (status != null && getId() != null) {
            messageBox.add("The station is out of service");
        }

    }

    public void val_total_price(List<String> messageBox) {

        if (price != null && !price.isGreaterThanZero()) {
            messageBox.add("the price must be greater than zero");
        }
    }

    public void val_items_price(List<String> messageBox) {

        MoneyVo itemsTotal = items.stream().map(item -> {
            val_item_price(item, messageBox);
            return item.getTotal();
        }).reduce(MoneyVo.ZERO, MoneyVo::add);

        if (itemsTotal.getAmount().compareTo(price.getAmount()) != 0) {

            messageBox.add("The total price of the reservation and the sum of the vehicles do not coincide");
        }

    }

    private void val_item_price(ReservationItem item, List<String> messageBox) {

        if (!item.is_price_valid()) {
            messageBox.add("price is not valid");
        }

    }

    public void init_reservation(ReservationAgg reservation) {

        setId(new ReservationId(UUID.randomUUID()));
        trackingId = new TrackingId(UUID.randomUUID());
        status = ReservationStatus.PENDING;

        for (ReservationItem item : items) {
            item.init_reservation_item(super.getId(), new ReservationItemId(UUID.randomUUID()));
        }

    }

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

    public void setStatus(ReservationStatus status) {

        this.status = status;
    }

    public List<String> getMessageBox() {

        return messageBox;
    }

    public void setMessageBox(List<String> messageBox) {

        this.messageBox = messageBox;
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

}
