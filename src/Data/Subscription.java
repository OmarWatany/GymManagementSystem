package Data;

import Persons.Coach;
import Persons.Customer;

public class Subscription {
    public int customerID, coachID;
    MemberShipPlan membershipPlan;
    public String subscription_date;

    public Subscription(int customerID, int CoachID , MemberShipPlan membership ) {
        this.coachID = CoachID;
        this.customerID = customerID;
         this.membershipPlan = membership;
    }

    public Customer getCustomer(int id){
        for(Customer cstmr: Gym.Customers){
            if(cstmr.getId() == id)
                return cstmr;
        }
        return null;
    }

    public Coach getCoach(int id){
        for(Coach coach : Gym.Coaches){
            if(coach.getId() == id)
                return coach;
        }
        return null;
    }
}
