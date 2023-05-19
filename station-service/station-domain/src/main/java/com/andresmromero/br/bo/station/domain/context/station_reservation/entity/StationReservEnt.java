package com.andresmromero.br.bo.station.domain.context.station_reservation.entity;

import java.math.BigDecimal;
import java.util.UUID;

public class StationReservEnt {

    private UUID stationId;

    private UUID vehicleId;

    private String stationName;

    private Boolean vehicleIsActive;

    private String vehicleName;

    private BigDecimal vehiclePrice;

    private Boolean vehicleAvailable;
    private UUID vehicleBrand;
    private UUID vehicleModel;
    private Boolean stationActive;

    public StationReservEnt(UUID stationId,
                            UUID vehicleId,
                            String stationName,
                            Boolean vehicleIsActive,
                            String vehicleName,
                            BigDecimal vehiclePrice,
                            Boolean vehicleAvailable,
                            UUID vehicleBrand,
                            UUID vehicleModel,
                            Boolean stationActive) {

        this.stationId = stationId;
        this.vehicleId = vehicleId;
        this.stationName = stationName;
        this.vehicleIsActive = vehicleIsActive;
        this.vehicleName = vehicleName;
        this.vehiclePrice = vehiclePrice;
        this.vehicleAvailable = vehicleAvailable;
        this.vehicleBrand = vehicleBrand;
        this.vehicleModel = vehicleModel;
        this.stationActive = stationActive;
    }

    public UUID getStationId() {

        return stationId;
    }

    public void setStationId(UUID stationId) {

        this.stationId = stationId;
    }

    public UUID getVehicleId() {

        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {

        this.vehicleId = vehicleId;
    }

    public String getStationName() {

        return stationName;
    }

    public void setStationName(String stationName) {

        this.stationName = stationName;
    }

    public Boolean getVehicleIsActive() {

        return vehicleIsActive;
    }

    public void setVehicleIsActive(Boolean vehicleIsActive) {

        this.vehicleIsActive = vehicleIsActive;
    }

    public String getVehicleName() {

        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {

        this.vehicleName = vehicleName;
    }

    public BigDecimal getVehiclePrice() {

        return vehiclePrice;
    }

    public void setVehiclePrice(BigDecimal vehiclePrice) {

        this.vehiclePrice = vehiclePrice;
    }

    public Boolean getVehicleAvailable() {

        return vehicleAvailable;
    }

    public void setVehicleAvailable(Boolean vehicleAvailable) {

        this.vehicleAvailable = vehicleAvailable;
    }

    public UUID getVehicleBrand() {

        return vehicleBrand;
    }

    public void setVehicleBrand(UUID vehicleBrand) {

        this.vehicleBrand = vehicleBrand;
    }

    public UUID getVehicleModel() {

        return vehicleModel;
    }

    public void setVehicleModel(UUID vehicleModel) {

        this.vehicleModel = vehicleModel;
    }

    public Boolean getStationActive() {

        return stationActive;
    }

    public void setStationActive(Boolean stationActive) {

        this.stationActive = stationActive;
    }

}
