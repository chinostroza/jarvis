package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ZoneParkingInventory {

    
    @SerializedName("zoneParkingId")
    private int zoneParkingId;
    
    @SerializedName("noOfParking")
    private int noOfParking;
    

    public ZoneParkingInventory() {}


    
    public int getZoneparkingid() {
        return zoneParkingId;
    }

    public void setZoneparkingid(int zoneParkingId) {
        this.zoneParkingId = zoneParkingId;
    }
    
    public int getNoofparking() {
        return noOfParking;
    }

    public void setNoofparking(int noOfParking) {
        this.noOfParking = noOfParking;
    }
    
}