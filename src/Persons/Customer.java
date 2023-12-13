package Persons;

import java.util.ArrayList;
import java.util.Date;
import Data.*;

public class Customer extends Person {
  public Date last_InBody_date;
  public Boolean is_Subscribed;
  public ArrayList<InBody> inBodies = new ArrayList<>() ;
  public Data.Subscription subscription;

  public Customer(int id, String name, String gender, String address, String number, String email,
      Subscription subscription) {
    super(id, name, gender, address, number, email);
    is_Subscribed = true;
    this.subscription = subscription;
  }

  public int customer_getId() {
    return ID;
  }

  public void set_subscription(Boolean f) {
    is_Subscribed = f;
  }

  public InBody get_InBody_info(Date date) {
    for (InBody inbody : inBodies) {
      if (date.equals(inbody.getDate())) {
        return inbody;
      }
    }
    System.out.println("There is no InBodies registered at this date");
    return null;
  }
}