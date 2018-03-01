package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Zone {

    
    @SerializedName("zoneId")
    private int zoneId;
    
    @SerializedName("zoneName")
    private String zoneName;
    
    @SerializedName("latitude")
    private float latitude;
    
    @SerializedName("longitude")
    private float longitude;
    
    @SerializedName("zonePrice")
    private int zonePrice;
    
    @SerializedName("zoneStatus")
    private String zoneStatus;
    
    @SerializedName("zoneParkingInventory")
    private ZoneParkingInventory zoneParkingInventory;
    
    @SerializedName("region")
    private String region;
    
    @SerializedName("infrastructure")
    private ArrayList<String> infrastructure;
    
    @SerializedName("noOfParking")
    private int noOfParking;
    
    @SerializedName("zoneAddress")
    private String zoneAddress;
    
    @SerializedName("zoneIncharge")
    private int zoneIncharge;
    
    @SerializedName("availableParkingSlot")
    private int availableParkingSlot;
    
    @SerializedName("city")
    private String city;
    
    @SerializedName("zoneInchargeName")
    private String zoneInchargeName;
    
    @SerializedName("polyCordinate")
    private String polyCordinate;
    
    @SerializedName("endZonePrice")
    private int endZonePrice;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("imageUrl")
    private String imageUrl;
    
    @SerializedName("enableZoneInfo")
    private boolean enableZoneInfo;
    
    @SerializedName("showZoneInfo")
    private String showZoneInfo;
    

    public Zone() {}


    
    public int getZoneid() {
        return zoneId;
    }

    public void setZoneid(int zoneId) {
        this.zoneId = zoneId;
    }
    
    public String getZonename() {
        return zoneName;
    }

    public void setZonename(String zoneName) {
        this.zoneName = zoneName;
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
    
    public int getZoneprice() {
        return zonePrice;
    }

    public void setZoneprice(int zonePrice) {
        this.zonePrice = zonePrice;
    }
    
    public String getZonestatus() {
        return zoneStatus;
    }

    public void setZonestatus(String zoneStatus) {
        this.zoneStatus = zoneStatus;
    }
    
    public ZoneParkingInventory getZoneparkinginventory() {
        return zoneParkingInventory;
    }

    public void setZoneparkinginventory(ZoneParkingInventory zoneParkingInventory) {
        this.zoneParkingInventory = zoneParkingInventory;
    }
    
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    public ArrayList<String> getInfrastructure() {
        return infrastructure;
    }

    public void setInfrastructure(ArrayList<String> infrastructure) {
        this.infrastructure = infrastructure;
    }
    
    public int getNoofparking() {
        return noOfParking;
    }

    public void setNoofparking(int noOfParking) {
        this.noOfParking = noOfParking;
    }
    
    public String getZoneaddress() {
        return zoneAddress;
    }

    public void setZoneaddress(String zoneAddress) {
        this.zoneAddress = zoneAddress;
    }
    
    public int getZoneincharge() {
        return zoneIncharge;
    }

    public void setZoneincharge(int zoneIncharge) {
        this.zoneIncharge = zoneIncharge;
    }
    
    public int getAvailableparkingslot() {
        return availableParkingSlot;
    }

    public void setAvailableparkingslot(int availableParkingSlot) {
        this.availableParkingSlot = availableParkingSlot;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getZoneinchargename() {
        return zoneInchargeName;
    }

    public void setZoneinchargename(String zoneInchargeName) {
        this.zoneInchargeName = zoneInchargeName;
    }
    
    public String getPolycordinate() {
        return polyCordinate;
    }

    public void setPolycordinate(String polyCordinate) {
        this.polyCordinate = polyCordinate;
    }
    
    public int getEndzoneprice() {
        return endZonePrice;
    }

    public void setEndzoneprice(int endZonePrice) {
        this.endZonePrice = endZonePrice;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getImageurl() {
        return imageUrl;
    }

    public void setImageurl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    public boolean getEnablezoneinfo() {
        return enableZoneInfo;
    }

    public void setEnablezoneinfo(boolean enableZoneInfo) {
        this.enableZoneInfo = enableZoneInfo;
    }
    
    public String getShowzoneinfo() {
        return showZoneInfo;
    }

    public void setShowzoneinfo(String showZoneInfo) {
        this.showZoneInfo = showZoneInfo;
    }
    
}