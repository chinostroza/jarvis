package com.mobiag.awto.api2.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class CurrentTripRequest {

    
    @SerializedName("userToken")
    private String userToken;
    

    public CurrentTripRequest() {}


    
    public String getUsertoken() {
        return userToken;
    }

    public void setUsertoken(String userToken) {
        this.userToken = userToken;
    }
    
}