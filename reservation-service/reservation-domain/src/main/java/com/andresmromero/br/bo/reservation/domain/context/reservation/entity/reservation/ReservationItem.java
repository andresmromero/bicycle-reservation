package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation;

import com.andresmromero.br.bo.context.domain.model.BaseModel;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;
import com.andresmromero.br.bo.reservation.domain.context.reservation.vo.reservation.ReservationItemId;

public class ReservationItem extends BaseModel<ReservationItemId> {

    private final VehicleResv vehicle;
    private final int quantity;
    private final MoneyVo price;
    private final MoneyVo total;
    private ReservationId reservationId;

    private ReservationItem(Builder builder) {

        super.setId(builder.reservationItemId);
        reservationId = builder.reservationId;
        vehicle = builder.vehicle;
        quantity = builder.quantity;
        price = builder.price;
        total = builder.total;
    }

    public boolean is_price_valid() {


        boolean priceCalculationItems_totalPrice = price.multiply(quantity).equals(total);
        boolean greaterThanZero = price.isGreaterThanZero();
        return greaterThanZero && priceCalculationItems_totalPrice;

    }

    public void init_reservation_item(ReservationId id, ReservationItemId reservationItemId) {

        this.reservationId = reservationId;
        super.setId(reservationItemId);

    }

    public VehicleResv getVehicle() {

        return vehicle;
    }

    public int getQuantity() {

        return quantity;
    }

    public MoneyVo getPrice() {

        return price;
    }

    public MoneyVo getTotal() {

        return total;
    }

    public ReservationId getReservationId() {

        return reservationId;
    }

    public static final class Builder {

        private ReservationId reservationId;
        private VehicleResv vehicle;
        private int quantity;
        private MoneyVo price;
        private MoneyVo total;
        private ReservationItemId reservationItemId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder reservationId(ReservationId val) {

            reservationId = val;
            return this;
        }

        public Builder vehicle(VehicleResv val) {

            vehicle = val;
            return this;
        }

        public Builder quantity(int val) {

            quantity = val;
            return this;
        }

        public Builder price(MoneyVo val) {

            price = val;
            return this;
        }

        public Builder total(MoneyVo val) {

            total = val;
            return this;
        }

        public Builder reservationItemId(ReservationItemId val) {

            reservationItemId = val;
            return this;
        }

        public ReservationItem build() {

            return new ReservationItem(this);
        }

    }

}
