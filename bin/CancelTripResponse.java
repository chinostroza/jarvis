package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class CancelTripResponse {

    
    @SerializedName("status")
    private String status;
    

    public CancelTripResponse() {}


    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}