import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ZoneByRadius {

    
    @SerializedName("id")
    private int id;
    
    @SerializedName("name")
    private String name;
    
    @SerializedName("noOfCars")
    private int noOfCars;
    
    @SerializedName("distance")
    private String distance;
    
    @SerializedName("defaultValue")
    private boolean defaultValue;
    
    @SerializedName("lat")
    private String lat;
    
    @SerializedName("lng")
    private String lng;
    
    @SerializedName("cars")
    private ArrayList<Cars> cars;
    
    @SerializedName("kilometer")
    private int kilometer;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("imageUrl")
    private String imageUrl;
    
    @SerializedName("showZoneInfo")
    private boolean showZoneInfo;
    

    public ZoneByRadius() {}


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getNoofcars() {
        return noOfCars;
    }

    public void setNoofcars(int noOfCars) {
        this.noOfCars = noOfCars;
    }
    
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
    
    public boolean getDefaultvalue() {
        return defaultValue;
    }

    public void setDefaultvalue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
    
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }
    
    public ArrayList<Cars> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Cars> cars) {
        this.cars = cars;
    }
    
    public int getKilometer() {
        return kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
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
    
}