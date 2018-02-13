package com.mobiag.awto.api2.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class ProfileResponse {

    
    @SerializedName("success")
    private boolean success;
    
    @SerializedName("user")
    private User user;
    
    @SerializedName("formattedAddress")
    private String formattedAddress;
    
    @SerializedName("latitude")
    private float latitude;
    
    @SerializedName("longitude")
    private float longitude;
    
    @SerializedName("rutNo")
    private String rutNo;
    
    @SerializedName("chileIds")
    private ArrayList<String> chileIds;
    
    @SerializedName("drivingLicenseIds")
    private ArrayList<String> drivingLicenseIds;
    
    @SerializedName("userExits")
    private boolean userExits;
    
    @SerializedName("modifyMemberShip")
    private boolean modifyMemberShip;
    

    public ProfileResponse() {}


    
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String getFormattedaddress() {
        return formattedAddress;
    }

    public void setFormattedaddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
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
    
    public String getRutno() {
        return rutNo;
    }

    public void setRutno(String rutNo) {
        this.rutNo = rutNo;
    }
    
    public ArrayList<String> getChileids() {
        return chileIds;
    }

    public void setChileids(ArrayList<String> chileIds) {
        this.chileIds = chileIds;
    }
    
    public ArrayList<String> getDrivinglicenseids() {
        return drivingLicenseIds;
    }

    public void setDrivinglicenseids(ArrayList<String> drivingLicenseIds) {
        this.drivingLicenseIds = drivingLicenseIds;
    }
    
    public boolean getUserexits() {
        return userExits;
    }

    public void setUserexits(boolean userExits) {
        this.userExits = userExits;
    }
    
    public boolean getModifymembership() {
        return modifyMemberShip;
    }

    public void setModifymembership(boolean modifyMemberShip) {
        this.modifyMemberShip = modifyMemberShip;
    }
    
}