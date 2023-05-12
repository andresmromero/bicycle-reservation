package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation;

import com.andresmromero.br.bo.context.domain.model.BaseModel;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.VehicleId;

public class Vehicle extends BaseModel<VehicleId> {

    private final String name;
    private final String price;
    private final String brand;
    private final String model;

    private Vehicle(Builder builder) {

        super.setId(builder.vehicleId);
        name = builder.name;
        price = builder.price;
        brand = builder.brand;
        model = builder.model;
    }

    //<editor-fold desc="--> Getter - Builder">
    public String getName() {

        return name;
    }

    public String getPrice() {

        return price;
    }

    public String getBrand() {

        return brand;
    }

    public String getModel() {

        return model;
    }

    public static final class Builder {

        private String name;
        private String price;
        private String brand;
        private String model;
        private VehicleId vehicleId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder name(String val) {

            name = val;
            return this;
        }

        public Builder price(String val) {

            price = val;
            return this;
        }

        public Builder brand(String val) {

            brand = val;
            return this;
        }

        public Builder model(String val) {

            model = val;
            return this;
        }

        public Builder id(VehicleId val) {

            vehicleId = val;
            return this;
        }

        public Vehicle build() {

            return new Vehicle(this);
        }

    }
    //</editor-fold>

}
