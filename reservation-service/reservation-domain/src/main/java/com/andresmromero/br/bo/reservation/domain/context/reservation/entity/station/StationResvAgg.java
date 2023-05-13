package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.VehicleResv;

import java.util.List;

public class StationResvAgg extends AggregateRoot<StationId> {

    private final List<VehicleResv> vehicles;
    private final boolean isActive;

    private StationResvAgg(Builder builder) {

        super.setId(builder.stationId);
        vehicles = builder.vehicles;
        isActive = builder.isActive;
    }

    public boolean isActive() {

        return isActive;
    }

    public void val_init(StationResvAgg station, List<String> messageBox) {

        if (!station.isActive()) {
            messageBox.add("The station is out of service");

        }

    }

    public List<VehicleResv> getVehicles() {

        return vehicles;
    }

    public static final class Builder {

        private List<VehicleResv> vehicles;
        private boolean isActive;
        private StationId stationId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder vehicles(List<VehicleResv> val) {

            vehicles = val;
            return this;
        }

        public Builder isActive(boolean val) {

            isActive = val;
            return this;
        }

        public Builder stationId(StationId val) {

            stationId = val;
            return this;
        }

        public StationResvAgg build() {

            return new StationResvAgg(this);
        }

    }

}
