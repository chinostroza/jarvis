package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class VehiclesResponse {

    
    @SerializedName("vehicleId")
    private int vehicleId;
    
    @SerializedName("vehicleModel")
    private string vehicleModel;
    
    @SerializedName("vehicleType")
    private string vehicleType;
    
    @SerializedName("typeOfOperation")
    private string typeOfOperation;
    
    @SerializedName("vehicleImageUrl")
    private string vehicleImageUrl;
    
    @SerializedName("vehiclePrice")
    private int vehiclePrice;
    
    @SerializedName("vehicleMake")
    private string vehicleMake;
    
    @SerializedName("vehicleCurrentStatus")
    private string vehicleCurrentStatus;
    
    @SerializedName("simNumber")
    private string simNumber;
    
    @SerializedName("transmission")
    private string transmission;
    
    @SerializedName("combustible")
    private string combustible;
    
    @SerializedName("fuelPercent")
    private float fuelPercent;
    
    @SerializedName("kilometer")
    private float kilometer;
    
    @SerializedName("patent")
    private string patent;
    
    @SerializedName("obs")
    private string obs;
    
    @SerializedName("insuranceCompany")
    private string insuranceCompany;
    
    @SerializedName("insuranceNumber")
    private string insuranceNumber;
    
    @SerializedName("stationBasedzoneIds")
    private StationBasedzoneIds stationBasedzoneIds;
    
    @SerializedName("inventory")
    private Inventory inventory;
    
    @SerializedName("inventories")
    private Inventories inventories;
    
    @SerializedName("maintenances")
    private Maintenances maintenances;
    
    @SerializedName("latitude")
    private float latitude;
    
    @SerializedName("longitude")
    private float longitude;
    
    @SerializedName("fleetVehicleId")
    private int fleetVehicleId;
    
    @SerializedName("damageReports")
    private DamageReports damageReports;
    
    @SerializedName("lastModifiedDate")
    private int lastModifiedDate;
    
    @SerializedName("zoneInfo")
    private string zoneInfo;
    
    @SerializedName("order")
    private int order;
    
    @SerializedName("voltage")
    private int voltage;
    

    public VehiclesResponse() {}


    
    public int getVehicleid() {
        return vehicleId;
    }

    public void setVehicleid(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public string getVehiclemodel() {
        return vehicleModel;
    }

    public void setVehiclemodel(string vehicleModel) {
        this.vehicleModel = vehicleModel;
    }
    
    public string getVehicletype() {
        return vehicleType;
    }

    public void setVehicletype(string vehicleType) {
        this.vehicleType = vehicleType;
    }
    
    public string getTypeofoperation() {
        return typeOfOperation;
    }

    public void setTypeofoperation(string typeOfOperation) {
        this.typeOfOperation = typeOfOperation;
    }
    
    public string getVehicleimageurl() {
        return vehicleImageUrl;
    }

    public void setVehicleimageurl(string vehicleImageUrl) {
        this.vehicleImageUrl = vehicleImageUrl;
    }
    
    public int getVehicleprice() {
        return vehiclePrice;
    }

    public void setVehicleprice(int vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }
    
    public string getVehiclemake() {
        return vehicleMake;
    }

    public void setVehiclemake(string vehicleMake) {
        this.vehicleMake = vehicleMake;
    }
    
    public string getVehiclecurrentstatus() {
        return vehicleCurrentStatus;
    }

    public void setVehiclecurrentstatus(string vehicleCurrentStatus) {
        this.vehicleCurrentStatus = vehicleCurrentStatus;
    }
    
    public string getSimnumber() {
        return simNumber;
    }

    public void setSimnumber(string simNumber) {
        this.simNumber = simNumber;
    }
    
    public string getTransmission() {
        return transmission;
    }

    public void setTransmission(string transmission) {
        this.transmission = transmission;
    }
    
    public string getCombustible() {
        return combustible;
    }

    public void setCombustible(string combustible) {
        this.combustible = combustible;
    }
    
    public float getFuelpercent() {
        return fuelPercent;
    }

    public void setFuelpercent(float fuelPercent) {
        this.fuelPercent = fuelPercent;
    }
    
    public float getKilometer() {
        return kilometer;
    }

    public void setKilometer(float kilometer) {
        this.kilometer = kilometer;
    }
    
    public string getPatent() {
        return patent;
    }

    public void setPatent(string patent) {
        this.patent = patent;
    }
    
    public string getObs() {
        return obs;
    }

    public void setObs(string obs) {
        this.obs = obs;
    }
    
    public string getInsurancecompany() {
        return insuranceCompany;
    }

    public void setInsurancecompany(string insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    
    public string getInsurancenumber() {
        return insuranceNumber;
    }

    public void setInsurancenumber(string insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }
    
    public StationBasedzoneIds getStationbasedzoneids() {
        return stationBasedzoneIds;
    }

    public void setStationbasedzoneids(StationBasedzoneIds stationBasedzoneIds) {
        this.stationBasedzoneIds = stationBasedzoneIds;
    }
    
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    
    public Inventories getInventories() {
        return inventories;
    }

    public void setInventories(Inventories inventories) {
        this.inventories = inventories;
    }
    
    public Maintenances getMaintenances() {
        return maintenances;
    }

    public void setMaintenances(Maintenances maintenances) {
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
    
    public DamageReports getDamagereports() {
        return damageReports;
    }

    public void setDamagereports(DamageReports damageReports) {
        this.damageReports = damageReports;
    }
    
    public int getLastmodifieddate() {
        return lastModifiedDate;
    }

    public void setLastmodifieddate(int lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    public string getZoneinfo() {
        return zoneInfo;
    }

    public void setZoneinfo(string zoneInfo) {
        this.zoneInfo = zoneInfo;
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