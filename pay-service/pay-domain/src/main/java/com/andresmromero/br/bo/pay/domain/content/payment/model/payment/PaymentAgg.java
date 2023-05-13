package com.andresmromero.br.bo.pay.domain.content.payment.model.payment;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.PaymentId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationId;
import com.andresmromero.br.bo.context.domain.model.enums.PaymentStatus;
import com.andresmromero.br.bo.context.domain.vo.CustomerId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;

import java.time.ZonedDateTime;

public class PaymentAgg extends AggregateRoot<PaymentId> {

    private final ReservationId reservationId;
    private final MoneyVo price;
    private final CustomerId customerId;
    private PaymentStatus status;
    private ZonedDateTime createdAt;

    private PaymentAgg(Builder builder) {

        super.setId(builder.paymentId);
        reservationId = builder.reservationId;
        price = builder.price;
        customerId = builder.customerId;
        status = builder.status;
        createdAt = builder.createdAt;
    }

    public ReservationId getReservationId() {

        return reservationId;
    }

    public MoneyVo getPrice() {

        return price;
    }

    public CustomerId getCustomerId() {

        return customerId;
    }

    public PaymentStatus getStatus() {

        return status;
    }

    public ZonedDateTime getCreatedAt() {

        return createdAt;
    }

    public static final class Builder {

        private ReservationId reservationId;
        private MoneyVo price;
        private CustomerId customerId;
        private PaymentStatus status;
        private ZonedDateTime createdAt;
        private PaymentId paymentId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder reservationId(ReservationId val) {

            reservationId = val;
            return this;
        }

        public Builder price(MoneyVo val) {

            price = val;
            return this;
        }

        public Builder customerId(CustomerId val) {

            customerId = val;
            return this;
        }

        public Builder status(PaymentStatus val) {

            status = val;
            return this;
        }

        public Builder createdAt(ZonedDateTime val) {

            createdAt = val;
            return this;
        }

        public Builder paymentId(PaymentId val) {

            paymentId = val;
            return this;
        }

        public PaymentAgg build() {

            return new PaymentAgg(this);
        }

    }

}
