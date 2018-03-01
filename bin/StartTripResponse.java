package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class StartTripResponse {

    
    @SerializedName("emailAddress")
    private String emailAddress;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("tripStatus")
    private String tripStatus;
    

    public StartTripResponse() {}


    
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
    
    public String getTripstatus() {
        return tripStatus;
    }

    public void setTripstatus(String tripStatus) {
        this.tripStatus = tripStatus;
    }
    
}