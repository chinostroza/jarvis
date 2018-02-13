package com.mobiag.awto.api2.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class TripDetail {

    
    @SerializedName("tripId")
    private int tripId;
    
    @SerializedName("userId")
    private int userId;
    
    @SerializedName("startZone")
    private StartZone startZone;
    
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
    private Long bookingTime;
    
    @SerializedName("repriceRequired")
    private boolean repriceRequired;
    
    @SerializedName("reservedParkingTime")
    private int reservedParkingTime;
    
    @SerializedName("timeRemainingToStartTrip")
    private int timeRemainingToStartTrip;
    
    @SerializedName("parkingTimeLeft")
    private int parkingTimeLeft;
    

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
    
    public StartZone getStartzone() {
        return startZone;
    }

    public void setStartzone(StartZone startZone) {
        this.startZone = startZone;
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
    
    public Long getBookingtime() {
        return bookingTime;
    }

    public void setBookingtime(Long bookingTime) {
        this.bookingTime = bookingTime;
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
    
}