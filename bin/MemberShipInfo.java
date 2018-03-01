package ;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class MemberShipInfo {

    
    @SerializedName("membershipId")
    private int membershipId;
    
    @SerializedName("membershipType")
    private String membershipType;
    
    @SerializedName("membershipName")
    private String membershipName;
    
    @SerializedName("membershipActive")
    private boolean membershipActive;
    
    @SerializedName("membershipAmount")
    private int membershipAmount;
    
    @SerializedName("memberId")
    private int memberId;
    
    @SerializedName("renewalDate")
    private int renewalDate;
    

    public MemberShipInfo() {}


    
    public int getMembershipid() {
        return membershipId;
    }

    public void setMembershipid(int membershipId) {
        this.membershipId = membershipId;
    }
    
    public String getMembershiptype() {
        return membershipType;
    }

    public void setMembershiptype(String membershipType) {
        this.membershipType = membershipType;
    }
    
    public String getMembershipname() {
        return membershipName;
    }

    public void setMembershipname(String membershipName) {
        this.membershipName = membershipName;
    }
    
    public boolean getMembershipactive() {
        return membershipActive;
    }

    public void setMembershipactive(boolean membershipActive) {
        this.membershipActive = membershipActive;
    }
    
    public int getMembershipamount() {
        return membershipAmount;
    }

    public void setMembershipamount(int membershipAmount) {
        this.membershipAmount = membershipAmount;
    }
    
    public int getMemberid() {
        return memberId;
    }

    public void setMemberid(int memberId) {
        this.memberId = memberId;
    }
    
    public int getRenewaldate() {
        return renewalDate;
    }

    public void setRenewaldate(int renewalDate) {
        this.renewalDate = renewalDate;
    }
    
}