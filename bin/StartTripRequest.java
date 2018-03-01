package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class StartTripRequest {

    
    @SerializedName("userToken")
    private String userToken;
    
    @SerializedName("tripId")
    private String tripId;
    

    public StartTripRequest() {}


    
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
    
}