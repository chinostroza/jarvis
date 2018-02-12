package com.mobiag.awto.api2.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class CurrentTripResponse {

    
    @SerializedName("tripDetail")
    private TripDetail tripDetail;
    
    @SerializedName("success")
    private boolean success;
    

    public CurrentTripResponse() {}


    
    public TripDetail getTripdetail() {
        return tripDetail;
    }

    public void setTripdetail(TripDetail tripDetail) {
        this.tripDetail = tripDetail;
    }
    
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
}