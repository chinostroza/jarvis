import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GetZonesRequest {

    
    @SerializedName("latitude")
    private String latitude;
    
    @SerializedName("location")
    private String location;
    
    @SerializedName("longitude")
    private String longitude;
    
    @SerializedName("radius")
    private int radius;
    
    @SerializedName("tripId")
    private int tripId;
    
    @SerializedName("userToken")
    private String userToken;
    

    public GetZonesRequest() {}


    
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public int getTripid() {
        return tripId;
    }

    public void setTripid(int tripId) {
        this.tripId = tripId;
    }
    
    public String getUsertoken() {
        return userToken;
    }

    public void setUsertoken(String userToken) {
        this.userToken = userToken;
    }
    
}