package com.andresmromero.br.bo.station.domain.context.station_reservation.model.station;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ReservationReceivedId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationReceivedStatus;
import com.andresmromero.br.bo.context.domain.model.enums.ReservationStatus;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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

    public ReservationReceivedStn getReservationReceived() {

        return reservationReceived;
    }

    public boolean isActive() {

        return isActive;
    }

    public void setActive(boolean active) {

        isActive = active;
    }

    public ReservationDetailStn getReservationDetail() {

        return reservationDetail;
    }

    public void val_reservation(List<String> messageBox) {

        if (!reservationDetail.getStatus().equals(ReservationStatus.PAID)) {
            messageBox.add("Reservation is not paid");
        }

        MoneyVo total = reservationDetail.getVehicleList().stream().map(

                veh -> {
                    if (!veh.isAvailable()) {
                        messageBox.add("Vehicles is no available");
                    }
                    return veh.getPrice().multiply(veh.getQuantity());
                }).reduce(MoneyVo.ZERO, MoneyVo::add);

        BigDecimal reservationDetailTotal = reservationDetail.getTotal().getAmount();
        BigDecimal allPriceQuantity = total.getAmount();


        if (allPriceQuantity.compareTo(reservationDetailTotal) != 0) {
            messageBox.add("Total is not correct");
        }
    }

    public void generate_approval_reservation(ReservationReceivedStatus status) {

        this.reservationReceived = ReservationReceivedStn.Builder.builder()
                                                                 .reservationReceivedId(new ReservationReceivedId(UUID.randomUUID()))
                                                                 .stationId(this.getId())
                                                                 .reservationId(this.getReservationDetail().getId())
                                                                 .status(status)
                                                                 .build();

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

        public Builder id(StationId val) {

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
