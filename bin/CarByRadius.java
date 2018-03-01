import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class CarByRadius {

    
    @SerializedName("id")
    private int id;
    
    @SerializedName("img")
    private String img;
    
    @SerializedName("model")
    private String model;
    
    @SerializedName("fuel")
    private int fuel;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("tripType")
    private String tripType;
    
    @SerializedName("reserveUrl")
    private String reserveUrl;
    
    @SerializedName("platNo")
    private String platNo;
    
    @SerializedName("latitude")
    private float latitude;
    
    @SerializedName("longitude")
    private float longitude;
    

    public CarByRadius() {}


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getTriptype() {
        return tripType;
    }

    public void setTriptype(String tripType) {
        this.tripType = tripType;
    }
    
    public String getReserveurl() {
        return reserveUrl;
    }

    public void setReserveurl(String reserveUrl) {
        this.reserveUrl = reserveUrl;
    }
    
    public String getPlatno() {
        return platNo;
    }

    public void setPlatno(String platNo) {
        this.platNo = platNo;
    }
    
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }
    
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
}