package Persons;

import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import Data.*;
import interfaces.*;

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
    try{
      return ID;
    } catch (NullPointerException e){
      System.out.println("there is no customer " + e);
      return 0;
    }
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
    return subscription.getCoach();
  }

  public MemberShipPlan getPlan(){
    return subscription.getPlan();
  }

  /**
   * adds a new Inbody to the customer inbodies list
   * it use the date when it runs.
   */
  public void addInBody(){
    float height, fatMass, minerals, bodyWater, protein;
    System.out.print("Enter height : "  );
    height   = validatingInputs.inputFloat();
    System.out.print("Enter fatMass : " );
    fatMass  =validatingInputs.inputFloat();
    System.out.print("Enter minerals : " );
    minerals = validatingInputs.inputFloat();
    System.out.print("Enter bodyWater : ");
    bodyWater= validatingInputs.inputFloat();
    System.out.print("Enter protein : ");
    protein  = validatingInputs.inputFloat();
    Date date = new Date();
    long diffinMillis, diff;
    if( inBodies.size() > 0 ){
        Date firstDate = inBodies.get(inBodies.size() -1 ).getDate();
        diffinMillis = date.getTime() - firstDate.getTime();
        diff = TimeUnit.DAYS.convert(diffinMillis, TimeUnit.MILLISECONDS);
    } else{
        diff = 31;
    }

    if(diff > 30){
      try{
        InBody newInBody = new InBody(ID,date,height,fatMass,minerals,bodyWater,protein );
        inBodies.add(newInBody);
      } catch (NoSuchElementException e){
        System.out.println("error " + e);
      }
    } else{
      System.out.println("Can't add two inbodies in one month");
    }

  }

}