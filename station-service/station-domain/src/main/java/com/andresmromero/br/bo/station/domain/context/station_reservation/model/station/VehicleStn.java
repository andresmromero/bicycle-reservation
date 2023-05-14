package com.andresmromero.br.bo.station.domain.context.station_reservation.model.station;

import com.andresmromero.br.bo.context.domain.model.BaseModel;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.BrandId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ModelId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.VehicleId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;

public class VehicleStn extends BaseModel<VehicleId> {

    private final BrandId brand;
    private final ModelId model;
    private String name;
    private MoneyVo price;
    private final int quantity;
    private boolean available;

    private VehicleStn(Builder builder) {
        super.setId(builder.vehicleId);
        brand = builder.brand;
        model = builder.model;
        name = builder.name;
        price = builder.price;
        quantity = builder.quantity;
        available = builder.available;
    }


    public static final class Builder {

        private VehicleId vehicleId;
        private BrandId brand;
        private ModelId model;
        private String name;
        private MoneyVo price;
        private int quantity;
        private boolean available;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder id(VehicleId val) {

            vehicleId = val;
            return this;
        }

        public Builder brand(BrandId val) {

            brand = val;
            return this;
        }

        public Builder model(ModelId val) {

            model = val;
            return this;
        }

        public Builder name(String val) {

            name = val;
            return this;
        }

        public Builder price(MoneyVo val) {

            price = val;
            return this;
        }

        public Builder quantity(int val) {

            quantity = val;
            return this;
        }

        public Builder available(boolean val) {

            available = val;
            return this;
        }

        public VehicleStn build() {

            return new VehicleStn(this);
        }

    }

}
