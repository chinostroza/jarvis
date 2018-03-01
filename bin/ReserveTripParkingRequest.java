package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ReserveTripParkingRequest {

    
    @SerializedName("userToken")
    private String userToken;
    
    @SerializedName("tripId")
    private String tripId;
    
    @SerializedName("zoneId")
    private String zoneId;
    

    public ReserveTripParkingRequest() {}


    
    public String getUsertoken() {
        return userToken;
    }

    public void setUsertoken(String userToken) {
        this.userToken = userToken;
    }
    
    public String getTripid() {
        return tripId;
    }

    public void setTripid(String tripId) {
        this.tripId = tripId;
    }
    
    public String getZoneid() {
        return zoneId;
    }

    public void setZoneid(String zoneId) {
        this.zoneId = zoneId;
    }
    
}