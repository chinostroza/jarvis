package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class FinishTripResponse {

    
    @SerializedName("emailAddress")
    private String emailAddress;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("tripDetail")
    private TripDetail tripDetail;
    

    public FinishTripResponse() {}


    
    public String getEmailaddress() {
        return emailAddress;
    }

    public void setEmailaddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public TripDetail getTripdetail() {
        return tripDetail;
    }

    public void setTripdetail(TripDetail tripDetail) {
        this.tripDetail = tripDetail;
    }
    
}