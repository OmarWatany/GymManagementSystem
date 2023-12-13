package Data;

import java.util.Date;

public class Subscription {
    public int customerID, coachID;
    // MemberShip membership;
    public String subscription_date;

    public Subscription(int customerID, int CoachID /* ,Membership membership */) {
        this.coachID = CoachID;
        this.customerID = customerID;
        // this.membership = membership;
    }
}
