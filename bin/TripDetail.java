package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class TripDetail {

    
    @SerializedName("tripId")
    private int tripId;
    
    @SerializedName("userId")
    private int userId;
    
    @SerializedName("emailId")
    private String emailId;
    
    @SerializedName("startZone")
    private StartZone startZone;
    
    @SerializedName("endZone")
    private EndZone endZone;
    
    @SerializedName("startTime")
    private int startTime;
    
    @SerializedName("endTime")
    private int endTime;
    
    @SerializedName("usageTime")
    private int usageTime;
    
    @SerializedName("standByTime")
    private int standByTime;
    
    @SerializedName("distanceTravel")
    private int distanceTravel;
    
    @SerializedName("waverStandByTime")
    private int waverStandByTime;
    
    @SerializedName("tripStatusCode")
    private int tripStatusCode;
    
    @SerializedName("vehicleInfo")
    private VehicleInfo vehicleInfo;
    
    @SerializedName("userInfo")
    private UserInfo userInfo;
    
    @SerializedName("extraTime")
    private int extraTime;
    
    @SerializedName("extraEndTime")
    private int extraEndTime;
    
    @SerializedName("tripStatusName")
    private String tripStatusName;
    
    @SerializedName("tripType")
    private String tripType;
    
    @SerializedName("bookingTime")
    private int bookingTime;
    
    @SerializedName("tripPriceInfoVO")
    private TripPriceInfoVO tripPriceInfoVO;
    
    @SerializedName("validTime")
    private int validTime;
    
    @SerializedName("repriceRequired")
    private boolean repriceRequired;
    
    @SerializedName("reservedParkingTime")
    private int reservedParkingTime;
    
    @SerializedName("timeRemainingToStartTrip")
    private int timeRemainingToStartTrip;
    
    @SerializedName("parkingTimeLeft")
    private int parkingTimeLeft;
    
    @SerializedName("tripPromotionsVOs")
    private ArrayList<String> tripPromotionsVOs;
    

    public TripDetail() {}


    
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
    
    public String getEmailid() {
        return emailId;
    }

    public void setEmailid(String emailId) {
        this.emailId = emailId;
    }
    
    public StartZone getStartzone() {
        return startZone;
    }

    public void setStartzone(StartZone startZone) {
        this.startZone = startZone;
    }
    
    public EndZone getEndzone() {
        return endZone;
    }

    public void setEndzone(EndZone endZone) {
        this.endZone = endZone;
    }
    
    public int getStarttime() {
        return startTime;
    }

    public void setStarttime(int startTime) {
        this.startTime = startTime;
    }
    
    public int getEndtime() {
        return endTime;
    }

    public void setEndtime(int endTime) {
        this.endTime = endTime;
    }
    
    public int getUsagetime() {
        return usageTime;
    }

    public void setUsagetime(int usageTime) {
        this.usageTime = usageTime;
    }
    
    public int getStandbytime() {
        return standByTime;
    }

    public void setStandbytime(int standByTime) {
        this.standByTime = standByTime;
    }
    
    public int getDistancetravel() {
        return distanceTravel;
    }

    public void setDistancetravel(int distanceTravel) {
        this.distanceTravel = distanceTravel;
    }
    
    public int getWaverstandbytime() {
        return waverStandByTime;
    }

    public void setWaverstandbytime(int waverStandByTime) {
        this.waverStandByTime = waverStandByTime;
    }
    
    public int getTripstatuscode() {
        return tripStatusCode;
    }

    public void setTripstatuscode(int tripStatusCode) {
        this.tripStatusCode = tripStatusCode;
    }
    
    public VehicleInfo getVehicleinfo() {
        return vehicleInfo;
    }

    public void setVehicleinfo(VehicleInfo vehicleInfo) {
        this.vehicleInfo = vehicleInfo;
    }
    
    public UserInfo getUserinfo() {
        return userInfo;
    }

    public void setUserinfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    
    public int getExtratime() {
        return extraTime;
    }

    public void setExtratime(int extraTime) {
        this.extraTime = extraTime;
    }
    
    public int getExtraendtime() {
        return extraEndTime;
    }

    public void setExtraendtime(int extraEndTime) {
        this.extraEndTime = extraEndTime;
    }
    
    public String getTripstatusname() {
        return tripStatusName;
    }

    public void setTripstatusname(String tripStatusName) {
        this.tripStatusName = tripStatusName;
    }
    
    public String getTriptype() {
        return tripType;
    }

    public void setTriptype(String tripType) {
        this.tripType = tripType;
    }
    
    public int getBookingtime() {
        return bookingTime;
    }

    public void setBookingtime(int bookingTime) {
        this.bookingTime = bookingTime;
    }
    
    public TripPriceInfoVO getTrippriceinfovo() {
        return tripPriceInfoVO;
    }

    public void setTrippriceinfovo(TripPriceInfoVO tripPriceInfoVO) {
        this.tripPriceInfoVO = tripPriceInfoVO;
    }
    
    public int getValidtime() {
        return validTime;
    }

    public void setValidtime(int validTime) {
        this.validTime = validTime;
    }
    
    public boolean getRepricerequired() {
        return repriceRequired;
    }

    public void setRepricerequired(boolean repriceRequired) {
        this.repriceRequired = repriceRequired;
    }
    
    public int getReservedparkingtime() {
        return reservedParkingTime;
    }

    public void setReservedparkingtime(int reservedParkingTime) {
        this.reservedParkingTime = reservedParkingTime;
    }
    
    public int getTimeremainingtostarttrip() {
        return timeRemainingToStartTrip;
    }

    public void setTimeremainingtostarttrip(int timeRemainingToStartTrip) {
        this.timeRemainingToStartTrip = timeRemainingToStartTrip;
    }
    
    public int getParkingtimeleft() {
        return parkingTimeLeft;
    }

    public void setParkingtimeleft(int parkingTimeLeft) {
        this.parkingTimeLeft = parkingTimeLeft;
    }
    
    public ArrayList<String> getTrippromotionsvos() {
        return tripPromotionsVOs;
    }

    public void setTrippromotionsvos(ArrayList<String> tripPromotionsVOs) {
        this.tripPromotionsVOs = tripPromotionsVOs;
    }
    
}