package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Cordinate {

    
    @SerializedName("lat")
    private float lat;
    
    @SerializedName("lng")
    private float lng;
    

    public Cordinate() {}


    
    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
    
    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }
    
}