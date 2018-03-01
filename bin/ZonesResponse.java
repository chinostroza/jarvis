package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ZonesResponse {

    
    @SerializedName("zones")
    private ArrayList<Zones> zones;
    
    @SerializedName("errors")
    private ArrayList<String> errors;
    
    @SerializedName("success")
    private boolean success;
    

    public ZonesResponse() {}


    
    public ArrayList<Zones> getZones() {
        return zones;
    }

    public void setZones(ArrayList<Zones> zones) {
        this.zones = zones;
    }
    
    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }
    
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}