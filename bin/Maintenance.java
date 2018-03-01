package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Maintenance {

    
    @SerializedName("id")
    private int id;
    
    @SerializedName("description")
    private String description;
    
    @SerializedName("creationDate")
    private int creationDate;
    
    @SerializedName("vehicleId")
    private int vehicleId;
    
    @SerializedName("lastModifiedDate")
    private int lastModifiedDate;
    
    @SerializedName("cost")
    private int cost;
    
    @SerializedName("maintenanceType")
    private String maintenanceType;
    
    @SerializedName("maintenanceDate")
    private int maintenanceDate;
    
    @SerializedName("userName")
    private String userName;
    
    @SerializedName("vehiclePatent")
    private String vehiclePatent;
    
    @SerializedName("userId")
    private int userId;
    
    @SerializedName("status")
    private String status;
    
    @SerializedName("dateString")
    private String dateString;
    

    public Maintenance() {}


    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getCreationdate() {
        return creationDate;
    }

    public void setCreationdate(int creationDate) {
        this.creationDate = creationDate;
    }
    
    public int getVehicleid() {
        return vehicleId;
    }

    public void setVehicleid(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    
    public int getLastmodifieddate() {
        return lastModifiedDate;
    }

    public void setLastmodifieddate(int lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    
    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public String getMaintenancetype() {
        return maintenanceType;
    }

    public void setMaintenancetype(String maintenanceType) {
        this.maintenanceType = maintenanceType;
    }
    
    public int getMaintenancedate() {
        return maintenanceDate;
    }

    public void setMaintenancedate(int maintenanceDate) {
        this.maintenanceDate = maintenanceDate;
    }
    
    public String getUsername() {
        return userName;
    }

    public void setUsername(String userName) {
        this.userName = userName;
    }
    
    public String getVehiclepatent() {
        return vehiclePatent;
    }

    public void setVehiclepatent(String vehiclePatent) {
        this.vehiclePatent = vehiclePatent;
    }
    
    public int getUserid() {
        return userId;
    }

    public void setUserid(int userId) {
        this.userId = userId;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDatestring() {
        return dateString;
    }

    public void setDatestring(String dateString) {
        this.dateString = dateString;
    }
    
}