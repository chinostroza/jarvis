package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class TripPriceInfoVO {

    
    @SerializedName("totalPrice")
    private float totalPrice;
    
    @SerializedName("extraKmAmount")
    private int extraKmAmount;
    
    @SerializedName("amount")
    private int amount;
    
    @SerializedName("discount")
    private int discount;
    
    @SerializedName("travelTimeAmount")
    private int travelTimeAmount;
    
    @SerializedName("standByTimeAmount")
    private int standByTimeAmount;
    
    @SerializedName("zoneAmount")
    private int zoneAmount;
    
    @SerializedName("discountAmount")
    private int discountAmount;
    
    @SerializedName("totalDistance")
    private int totalDistance;
    
    @SerializedName("extraKm")
    private int extraKm;
    
    @SerializedName("tax")
    private float tax;
    
    @SerializedName("repriceRequired")
    private boolean repriceRequired;
    
    @SerializedName("endZoneAmount")
    private int endZoneAmount;
    

    public TripPriceInfoVO() {}


    
    public float getTotalprice() {
        return totalPrice;
    }

    public void setTotalprice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public int getExtrakmamount() {
        return extraKmAmount;
    }

    public void setExtrakmamount(int extraKmAmount) {
        this.extraKmAmount = extraKmAmount;
    }
    
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    public int getTraveltimeamount() {
        return travelTimeAmount;
    }

    public void setTraveltimeamount(int travelTimeAmount) {
        this.travelTimeAmount = travelTimeAmount;
    }
    
    public int getStandbytimeamount() {
        return standByTimeAmount;
    }

    public void setStandbytimeamount(int standByTimeAmount) {
        this.standByTimeAmount = standByTimeAmount;
    }
    
    public int getZoneamount() {
        return zoneAmount;
    }

    public void setZoneamount(int zoneAmount) {
        this.zoneAmount = zoneAmount;
    }
    
    public int getDiscountamount() {
        return discountAmount;
    }

    public void setDiscountamount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
    
    public int getTotaldistance() {
        return totalDistance;
    }

    public void setTotaldistance(int totalDistance) {
        this.totalDistance = totalDistance;
    }
    
    public int getExtrakm() {
        return extraKm;
    }

    public void setExtrakm(int extraKm) {
        this.extraKm = extraKm;
    }
    
    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }
    
    public boolean getRepricerequired() {
        return repriceRequired;
    }

    public void setRepricerequired(boolean repriceRequired) {
        this.repriceRequired = repriceRequired;
    }
    
    public int getEndzoneamount() {
        return endZoneAmount;
    }

    public void setEndzoneamount(int endZoneAmount) {
        this.endZoneAmount = endZoneAmount;
    }
    
}