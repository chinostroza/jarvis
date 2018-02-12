package com.mobiag.awto.api2.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class UserInfo {

    
    @SerializedName("userId")
    private int userId;
    
    @SerializedName("registrationStep")
    private String registrationStep;
    
    @SerializedName("personalInfoUpdated")
    private boolean personalInfoUpdated;
    
    @SerializedName("userType")
    private String userType;
    
    @SerializedName("mobileNo")
    private String mobileNo;
    
    @SerializedName("rutNo")
    private String rutNo;
    
    @SerializedName("passportNo")
    private String passportNo;
    
    @SerializedName("residence")
    private String residence;
    
    @SerializedName("userExistis")
    private boolean userExistis;
    
    @SerializedName("modifyMenberShip")
    private boolean modifyMenberShip;
    

    public UserInfo() {}


    
    public int getUserid() {
        return userId;
    }

    public void setUserid(int userId) {
        this.userId = userId;
    }
    
    public String getRegistrationstep() {
        return registrationStep;
    }

    public void setRegistrationstep(String registrationStep) {
        this.registrationStep = registrationStep;
    }
    
    public boolean getPersonalinfoupdated() {
        return personalInfoUpdated;
    }

    public void setPersonalinfoupdated(boolean personalInfoUpdated) {
        this.personalInfoUpdated = personalInfoUpdated;
    }
    
    public String getUsertype() {
        return userType;
    }

    public void setUsertype(String userType) {
        this.userType = userType;
    }
    
    public String getMobileno() {
        return mobileNo;
    }

    public void setMobileno(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    public String getRutno() {
        return rutNo;
    }

    public void setRutno(String rutNo) {
        this.rutNo = rutNo;
    }
    
    public String getPassportno() {
        return passportNo;
    }

    public void setPassportno(String passportNo) {
        this.passportNo = passportNo;
    }
    
    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }
    
    public boolean getUserexistis() {
        return userExistis;
    }

    public void setUserexistis(boolean userExistis) {
        this.userExistis = userExistis;
    }
    
    public boolean getModifymenbership() {
        return modifyMenberShip;
    }

    public void setModifymenbership(boolean modifyMenberShip) {
        this.modifyMenberShip = modifyMenberShip;
    }
    
}