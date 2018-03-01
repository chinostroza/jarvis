import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class GetCarsRequest {

    
    @SerializedName("latitude")
    private float latitude;
    
    @SerializedName("location")
    private String location;
    
    @SerializedName("longitude")
    private float longitude;
    
    @SerializedName("radius")
    private int radius;
    
    @SerializedName("userToken")
    private String userToken;
    

    public GetCarsRequest() {}


    
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    public String getUsertoken() {
        return userToken;
    }

    public void setUsertoken(String userToken) {
        this.userToken = userToken;
    }
    
}