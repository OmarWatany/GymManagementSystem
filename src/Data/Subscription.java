package Data;

import Persons.Coach;
import Persons.Customer;
import interfaces.filewriting;

public class Subscription implements filewriting {
    public int customerID, coachID;
    MemberShipPlan membershipPlan;

    public Subscription(int customerID, int CoachID, MemberShipPlan membership) {
        this.coachID = CoachID;
        this.customerID = customerID;
        this.membershipPlan = membership;
    }

    public String getAllAttributes() {
        String attributes = "," + String.valueOf(customerID) + "," + String.valueOf(coachID) + ","
                + String.valueOf(membershipPlan.planId);

        return attributes;
    }

    public Customer getCustomer(int id) {
        for (Customer cstmr : Gym.Customers) {
            if (cstmr.getId() == id)
                return cstmr;
        }
        return null;
    }

    public MemberShipPlan getPlan(){
        return membershipPlan;
    }

    public Coach getCoach(int id) {
        for (Coach coach : Gym.Coaches) {
            if (coach.getId() == id)
                return coach;
        }
        return null;
    }
}
