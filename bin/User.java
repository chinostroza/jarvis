package com.mobiag.awto.api2.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class User {

    
    @SerializedName("userId")
    private int userId;
    
    @SerializedName("firstName")
    private String firstName;
    
    @SerializedName("lastName")
    private String lastName;
    
    @SerializedName("emailAddress")
    private String emailAddress;
    
    @SerializedName("activeStatus")
    private String activeStatus;
    
    @SerializedName("role")
    private String role;
    
    @SerializedName("registrationStep")
    private String registrationStep;
    
    @SerializedName("personalInfoUpdated")
    private boolean personalInfoUpdated;
    
    @SerializedName("userType")
    private String userType;
    
    @SerializedName("city")
    private String city;
    
    @SerializedName("state")
    private String state;
    
    @SerializedName("mobileNo")
    private String mobileNo;
    
    @SerializedName("memberShipInfo")
    private memberShipInfo memberShipInfo;
    

    public User() {}


    
    public int getUserid() {
        return userId;
    }

    public void setUserid(int userId) {
        this.userId = userId;
    }
    
    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }
    
    public String getEmailaddress() {
        return emailAddress;
    }

    public void setEmailaddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    
    public String getActivestatus() {
        return activeStatus;
    }

    public void setActivestatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String getMobileno() {
        return mobileNo;
    }

    public void setMobileno(String mobileNo) {
        this.mobileNo = mobileNo;
    }
    
    public memberShipInfo getMembershipinfo() {
        return memberShipInfo;
    }

    public void setMembershipinfo(memberShipInfo memberShipInfo) {
        this.memberShipInfo = memberShipInfo;
    }
    
}