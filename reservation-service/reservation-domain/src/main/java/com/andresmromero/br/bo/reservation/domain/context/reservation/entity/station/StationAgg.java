package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.station;

import com.andresmromero.br.bo.context.domain.model.aggregate_root.AggregateRoot;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.StationId;
import com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation.Vehicle;

import java.util.List;

public class StationAgg extends AggregateRoot<StationId> {

    private final List<Vehicle> vehicles;
    private final boolean isActive;

    private StationAgg(Builder builder) {

        super.setId(builder.stationId);
        vehicles = builder.vehicles;
        isActive = builder.isActive;
    }


    public static final class Builder {

        private List<Vehicle> vehicles;
        private boolean isActive;
        private StationId stationId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder vehicles(List<Vehicle> val) {

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

        public StationAgg build() {

            return new StationAgg(this);
        }

    }

}
