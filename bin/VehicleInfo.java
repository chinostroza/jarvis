package com.mobiag.awto.domain.entity;;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class VehicleInfo {

    
    @SerializedName("vehicleid")
    private int vehicleid;
    
    @SerializedName("vehicleModel")
    private String vehicleModel;
    
    @SerializedName("vehicleType")
    private String vehicleType;
    
    @SerializedName("typeOfOperation")
    private String typeOfOperation;
    
    @SerializedName("vehicleImageUrl")
    private String vehicleImageUrl;
    
    @SerializedName("vehicleMake")
    private String vehicleMake;
    
    @SerializedName("vehicleCurrentStatus")
    private String vehicleCurrentStatus;
    
    @SerializedName("simNumber")
    private String simNumber;
    
    @SerializedName("transmission")
    private String transmission;
    
    @SerializedName("combustible")
    private String combustible;
    
    @SerializedName("fuelPercent")
    private float fuelPercent;
    
    @SerializedName("kilometer")
    private int kilometer;
    
    @SerializedName("patent")
    private String patent;
    
    @SerializedName("obs")
    private String obs;
    
    @SerializedName("stationBasedzoneIds")
    private ArrayList<String> stationBasedzoneIds;
    
    @SerializedName("inventory")
    private ArrayList<String> inventory;
    
    @SerializedName("inventories")
    private ArrayList<String> inventories;
    
    @SerializedName("maintenances")
    private ArrayList<String> maintenances;
    
    @SerializedName("latitud")
    private float latitud;
    
    @SerializedName("longitud")
    private float longitud;
    
    @SerializedName("fleetVehicleId")
    private int fleetVehicleId;
    
    @SerializedName("damageReports")
    private ArrayList<String> damageReports;
    
    @SerializedName("currentzone")
    private String currentzone;
    
    @SerializedName("lastModifiedDate")
    private Long lastModifiedDate;
    
    @SerializedName("order")
    private int order;
    
    @SerializedName("voltage")
    private int voltage;
    

    public VehicleInfo() {}


    
    public int getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(int vehicleid) {
        this.vehicleid = vehicleid;
    }
    
    public String getVehiclemodel() {
        return vehicleModel;
    }

    public void setVehiclemodel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    
    public String getVehicletype() {
        return vehicleType;
    }

    public void setVehicletype(String vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    public String getTypeofoperation() {
        return typeOfOperation;
    }

    public void setTypeofoperation(String typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }
    
    public String getVehicleimageurl() {
        return vehicleImageUrl;
    }

    public void setVehicleimageurl(String vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }
    
    public String getVehiclemake() {
        return vehicleMake;
    }

    public void setVehiclemake(String vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
    
    public String getVehiclecurrentstatus() {
        return vehicleCurrentStatus;
    }

    public void setVehiclecurrentstatus(String vehicleCurrentStatus) {
        this.vehicleCurrentStatus = vehicleCurrentStatus;
    }
    
    public String getSimnumber() {
        return simNumber;
    }

    public void setSimnumber(String simNumber) {
        this.simNumber = simNumber;
    }
    
    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }
    
    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
    
    public float getFuelpercent() {
        return fuelPercent;
    }

    public void setFuelpercent(float fuelPercent) {
        this.fuelPercent = fuelPercent;
    }
    
    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }
    
    public String getPatent() {
        return patent;
    }

    public void setPatent(String patent) {
        this.patent = patent;
    }
    
    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public ArrayList<String> getStationbasedzoneids() {
        return stationBasedzoneIds;
    }

    public void setStationbasedzoneids(ArrayList<String> stationBasedzoneIds) {
        this.stationBasedzoneIds = stationBasedzoneIds;
    }
    
    public ArrayList<String> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<String> inventory) {
        this.inventory = inventory;
    }
    
    public ArrayList<String> getInventories() {
        return inventories;
    }

    public void setInventories(ArrayList<String> inventories) {
        this.inventories = inventories;
    }
    
    public ArrayList<String> getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(ArrayList<String> maintenances) {
        this.maintenances = maintenances;
    }
    
    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }
    
    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }
    
    public int getFleetvehicleid() {
        return fleetVehicleId;
    }

    public void setFleetvehicleid(int fleetVehicleId) {
        this.fleetVehicleId = fleetVehicleId;
    }
    
    public ArrayList<String> getDamagereports() {
        return damageReports;
    }

    public void setDamagereports(ArrayList<String> damageReports) {
        this.damageReports = damageReports;
    }
    
    public String getCurrentzone() {
        return currentzone;
    }

    public void setCurrentzone(String currentzone) {
        this.currentzone = currentzone;
    }
    
    public Long getLastmodifieddate() {
        return lastModifiedDate;
    }

    public void setLastmodifieddate(Long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
    
    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    
}