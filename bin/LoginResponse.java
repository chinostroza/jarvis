package com.mobiag.awto.api2.response;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class LoginResponse {

    
    @SerializedName("userToken")
    private String userToken;
    
    @SerializedName("errors")
    private ArrayList<String> errors;
    
    @SerializedName("success")
    private boolean success;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("firstName")
    private String firstName;
    
    @SerializedName("lastName")
    private String lastName;
    
    @SerializedName("userType")
    private String userType;
    

    public LoginResponse() {}


    
    public String getUsertoken() {
        return userToken;
    }

    public void setUsertoken(String userToken) {
        this.userToken = userToken;
    }
    
    public ArrayList<String> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<String> errors) {
        this.errors = errors;
    }
    
    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    
    public String getUsertype() {
        return userType;
    }

    public void setUsertype(String userType) {
        this.userType = userType;
    }
    
}