package com.andresmromero.br.bo.reservation.domain.context.reservation.entity.reservation;

import com.andresmromero.br.bo.context.domain.model.BaseModel;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.BrandId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.ModelId;
import com.andresmromero.br.bo.context.domain.model.attribute_Id.VehicleId;
import com.andresmromero.br.bo.context.domain.vo.MoneyVo;

public class VehicleResv extends BaseModel<VehicleId> {

    private final BrandId brand;
    private final ModelId model;
    private String name;
    private MoneyVo price;

    private VehicleResv(Builder builder) {

        super.setId(builder.vehicleId);
        name = builder.name;
        price = builder.price;
        brand = builder.brand;
        model = builder.model;
    }

    public void update_name_price(String name, MoneyVo price) {

        this.price = price;
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public MoneyVo getPrice() {

        return price;
    }

    public BrandId getBrand() {

        return brand;
    }

    public ModelId getModel() {

        return model;
    }

    public static final class Builder {

        private String name;
        private MoneyVo price;
        private BrandId brand;
        private ModelId model;
        private VehicleId vehicleId;

        private Builder() {}

        public static Builder builder() {

            return new Builder();
        }

        public Builder name(String val) {

            name = val;
            return this;
        }

        public Builder price(MoneyVo val) {

            price = val;
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

        public Builder vehicleId(VehicleId val) {

            vehicleId = val;
            return this;
        }

        public VehicleResv build() {

            return new VehicleResv(this);
        }

    }

}
