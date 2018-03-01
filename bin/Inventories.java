package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class Inventories {

    
    @SerializedName("accessoriesId")
    private int accessoriesId;
    
    @SerializedName("creationDate")
    private int creationDate;
    
    @SerializedName("user")
    private String user;
    
    @SerializedName("totalKms")
    private float totalKms;
    
    @SerializedName("awInventory")
    private ArrayList<String> awInventory;
    
    @SerializedName("active")
    private boolean active;
    
    @SerializedName("comment")
    private String comment;
    

    public Inventories() {}


    
    public int getAccessoriesid() {
        return accessoriesId;
    }

    public void setAccessoriesid(int accessoriesId) {
        this.accessoriesId = accessoriesId;
    }
    
    public int getCreationdate() {
        return creationDate;
    }

    public void setCreationdate(int creationDate) {
        this.creationDate = creationDate;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public float getTotalkms() {
        return totalKms;
    }

    public void setTotalkms(float totalKms) {
        this.totalKms = totalKms;
    }
    
    public ArrayList<String> getAwinventory() {
        return awInventory;
    }

    public void setAwinventory(ArrayList<String> awInventory) {
        this.awInventory = awInventory;
    }
    
    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}