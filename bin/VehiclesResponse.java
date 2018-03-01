package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class VehiclesResponse {

    
    @SerializedName("vehicles")
    private ArrayList<Vehicles> vehicles;
    
    @SerializedName("errors")
    private ArrayList<String> errors;
    
    @SerializedName("success")
    private boolean success;
    

    public VehiclesResponse() {}


    
    public ArrayList<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(ArrayList<Vehicles> vehicles) {
        this.vehicles = vehicles;
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