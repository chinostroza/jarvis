package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class VehicleInfo {

    
    @SerializedName("vehicleId")
    private int vehicleId;
    
    @SerializedName("vehicleModel")
    private String vehicleModel;
    
    @SerializedName("vehicleType")
    private String vehicleType;
    
    @SerializedName("typeOfOperation")
    private String typeOfOperation;
    
    @SerializedName("vehicleImageUrl")
    private String vehicleImageUrl;
    
    @SerializedName("vehiclePrice")
    private int vehiclePrice;
    
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
    private int fuelPercent;
    
    @SerializedName("kilometer")
    private float kilometer;
    
    @SerializedName("patent")
    private String patent;
    
    @SerializedName("obs")
    private String obs;
    
    @SerializedName("obsDriver")
    private String obsDriver;
    
    @SerializedName("stationBasedzoneIds")
    private ArrayList<String> stationBasedzoneIds;
    
    @SerializedName("inventory")
    private ArrayList<String> inventory;
    
    @SerializedName("inventories")
    private ArrayList<String> inventories;
    
    @SerializedName("maintenances")
    private ArrayList<String> maintenances;
    
    @SerializedName("latitude")
    private float latitude;
    
    @SerializedName("longitude")
    private float longitude;
    
    @SerializedName("fleetVehicleId")
    private int fleetVehicleId;
    
    @SerializedName("damageReports")
    private ArrayList<String> damageReports;
    
    @SerializedName("currentZone")
    private String currentZone;
    
    @SerializedName("lastModifiedDate")
    private int lastModifiedDate;
    
    @SerializedName("order")
    private int order;
    
    @SerializedName("voltage")
    private int voltage;
    

    public VehicleInfo() {}


    
    public int getVehicleid() {
        return vehicleId;
    }

    public void setVehicleid(int vehicleId) {
        this.vehicleId = vehicleId;
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
    
    public int getVehicleprice() {
        return vehiclePrice;
    }

    public void setVehicleprice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
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
    
    public int getFuelpercent() {
        return fuelPercent;
    }

    public void setFuelpercent(int fuelPercent) {
        this.fuelPercent = fuelPercent;
    }
    
    public float getKilometer() {
        return kilometer;
    }

    public void setKilometer(float kilometer) {
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
    
    public String getObsdriver() {
        return obsDriver;
    }

    public void setObsdriver(String obsDriver) {
        this.obsDriver = obsDriver;
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
    
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
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
        return currentZone;
    }

    public void setCurrentzone(String currentZone) {
        this.currentZone = currentZone;
    }
    
    public int getLastmodifieddate() {
        return lastModifiedDate;
    }

    public void setLastmodifieddate(int lastModifiedDate) {
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