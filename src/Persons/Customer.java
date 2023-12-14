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
      Subscription subscription,String uname,String pass) {
    super(id, name, gender, address, number, email,uname,pass);
    is_Subscribed = true;
    this.subscription = subscription;
  }

  public int getId() {
    return ID;
  }

  public void set_subscription(Boolean f) {
    is_Subscribed = f;
  }

  public InBody get_InBody(Date date) {
    for (InBody inbody : inBodies) {
      if (date.equals(inbody.getDate())) {
        return inbody;
      }
    }
    System.out.println("There is no InBodies registered at this date");
    return null;
  }

  public void printInBodyHistory(){
    for (InBody inbody : inBodies) {
      inbody.displayInformation();
    }
  }

  public void getInfo(){
    System.out.println("ID : " + ID);
    System.out.println("Name : " + Name);
    System.out.println("gender  : " + gender );
    System.out.println("Address  : " + Address ) ;
    System.out.println("PhoneNumber  : " + PhoneNumber ) ;
    System.out.println("Email  : " + Email );
  }

}