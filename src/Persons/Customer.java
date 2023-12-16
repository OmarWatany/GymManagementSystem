package Persons;

import java.util.ArrayList;
import java.util.Date;
import Data.*;

public class Customer extends Person {
  public Date lastInBodydate;
  public Boolean is_Subscribed;
  public ArrayList<InBody> inBodies = new ArrayList<>() ;

  public ArrayList<Subscription> subscriptions = new ArrayList<>();

  public Subscription subscription;

  /**
   * create customer object
   * @param id
   * @param name
   * @param gender
   * @param address
   * @param number
   * @param email
   * @param subscription
   * @param uname
   * @param pass
   */
  public Customer(int id, String name, String gender, String address, String number, String email,
      Subscription subscription,String uname,String pass) {
    super(id, name, gender, address, number, email,uname,pass);
    is_Subscribed = true;
    this.subscription = subscription;
    subscriptions.add(subscription);
  }

  public int getId() {
    return ID;
  }

  public void setSubscription(Boolean f) {
    is_Subscribed = f;
  }

  /**
   * search for inbody with date
   * @param date
   * YYYY-MM-DD
   * @return inbody
   * return inbody class
   */
  public InBody get_InBody(Date date) {
    for (InBody inbody : inBodies) {
      if (date.equals(inbody.getDate())) {
        return inbody;
      }
    }
    System.out.println("There is no InBodies registered at this date");
    return null;
  }

  /**
   * prints the customer InBody history.
   */
  public void printInBodyHistory(){
    for (InBody inbody : inBodies) {
      inbody.displayInformation();
    }
  }

  /**
   * prints the customer information
   */

  public void getInfo(){
    System.out.println("ID : " + ID);
    System.out.println("Name : " + Name);
    System.out.println("gender  : " + gender );
    System.out.println("Address  : " + Address ) ;
    System.out.println("PhoneNumber  : " + PhoneNumber ) ;
    System.out.println("Email  : " + Email );
  }

  public Coach getCoach(){
    return subscription.getCoach(subscription.coachID);
  }

  public MemberShipPlan getPlan(){
    return subscription.getPlan();
  }

}