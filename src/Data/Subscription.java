package Data;

import java.util.Date;

public class Subscription {
    public int customerID,CoachID;
    //MemberShip membership;
    public String subscription_date;

    public Subscription( int customerID, int CoachID){
        this.CoachID = CoachID;
        this.customerID = customerID;
        //this.membership = membership;
    }
}
