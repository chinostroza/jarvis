import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GetCarsResponse {

    
    @SerializedName("status")
    private String status;
    
    @SerializedName("message")
    private String message;
    
    @SerializedName("location")
    private String location;
    
    @SerializedName("lat")
    private float lat;
    
    @SerializedName("lng")
    private float lng;
    
    @SerializedName("radius")
    private int radius;
    
    @SerializedName("zones")
    private ArrayList<Zones> zones;
    

    public GetCarsResponse() {}


    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public ArrayList<Zones> getZones() {
        return zones;
    }

    public void setZones(ArrayList<Zones> zones) {
        this.zones = zones;
    }
    
}