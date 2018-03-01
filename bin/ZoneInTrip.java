import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ZoneInTrip {

    
    @SerializedName("id")
    private int id;
    
    @SerializedName("url")
    private String url;
    
    @SerializedName("name")
    private String name;
    
    @SerializedName("regionComuna")
    private String regionComuna;
    
    @SerializedName("lat")
    private float lat;
    
    @SerializedName("lng")
    private float lng;
    
    @SerializedName("totalSpace")
    private int totalSpace;
    
    @SerializedName("availSpace")
    private int availSpace;
    
    @SerializedName("spaceStatus")
    private String spaceStatus;
    
    @SerializedName("kilometer")
    private int kilometer;
    
    @SerializedName("distance")
    private String distance;
    
    @SerializedName("fuel")
    private boolean fuel;
    
    @SerializedName("charging")
    private boolean charging;
    
    @SerializedName("formattedAddress")
    private String formattedAddress;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("imageUrl")
    private String imageUrl;
    
    @SerializedName("showZoneInfo")
    private boolean showZoneInfo;
    
    @SerializedName("isArea")
    private boolean isArea;
    
    @SerializedName("polygonList")
    private ArrayList<PolygonList> polygonList;
    
    @SerializedName("hasBikeRack")
    private boolean hasBikeRack;
    

    public ZoneInTrip() {}


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getRegioncomuna() {
        return regionComuna;
    }

    public void setRegioncomuna(String regionComuna) {
        this.regionComuna = regionComuna;
    }
    
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
    
    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
    
    public int getTotalspace() {
        return totalSpace;
    }

    public void setTotalspace(int totalSpace) {
        this.totalSpace = totalSpace;
    }
    
    public int getAvailspace() {
        return availSpace;
    }

    public void setAvailspace(int availSpace) {
        this.availSpace = availSpace;
    }
    
    public String getSpacestatus() {
        return spaceStatus;
    }

    public void setSpacestatus(String spaceStatus) {
        this.spaceStatus = spaceStatus;
    }
    
    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }
    
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    
    public boolean getFuel() {
        return fuel;
    }

    public void setFuel(boolean fuel) {
        this.fuel = fuel;
    }
    
    public boolean getCharging() {
        return charging;
    }

    public void setCharging(boolean charging) {
        this.charging = charging;
    }
    
    public String getFormattedaddress() {
        return formattedAddress;
    }

    public void setFormattedaddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
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
    
    public boolean getShowzoneinfo() {
        return showZoneInfo;
    }

    public void setShowzoneinfo(boolean showZoneInfo) {
        this.showZoneInfo = showZoneInfo;
    }
    
    public boolean getIsarea() {
        return isArea;
    }

    public void setIsarea(boolean isArea) {
        this.isArea = isArea;
    }
    
    public ArrayList<PolygonList> getPolygonlist() {
        return polygonList;
    }

    public void setPolygonlist(ArrayList<PolygonList> polygonList) {
        this.polygonList = polygonList;
    }
    
    public boolean getHasbikerack() {
        return hasBikeRack;
    }

    public void setHasbikerack(boolean hasBikeRack) {
        this.hasBikeRack = hasBikeRack;
    }
    
}