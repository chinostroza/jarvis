

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ReserveTripParkingResponse {

    
    @SerializedName("success")
    private boolean success;
    
    @SerializedName("tripId")
    private int tripId;
    
    @SerializedName("userId")
    private int userId;
    
    @SerializedName("zoneId")
    private int zoneId;
    
    @SerializedName("vehicleId")
    private int vehicleId;
    
    @SerializedName("minutes")
    private int minutes;
    

    public ReserveTripParkingResponse() {}


    
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public int getTripid() {
        return tripId;
    }

    public void setTripid(int tripId) {
        this.tripId = tripId;
    }
    
    public int getUserid() {
        return userId;
    }

    public void setUserid(int userId) {
        this.userId = userId;
    }
    
    public int getZoneid() {
        return zoneId;
    }

    public void setZoneid(int zoneId) {
        this.zoneId = zoneId;
    }
    
    public int getVehicleid() {
        return vehicleId;
    }

    public void setVehicleid(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }
    
}