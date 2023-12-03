package GYM;

import Data.Person;
import Data.Subscription;

public class Coach extends Person {
    private int workingHours;
    Customer[] customers ;
   public Coach(int id, String name, String gender, String address,
                String number, String email, int workingHours){
       super(id,name,gender,address,number,email);
       this.workingHours = Math.min(workingHours, 10);
   }
    public void getName(){
        System.out.println(Name);
    }
    public void getWorkingHours(){
        System.out.println(workingHours);
    }
    public void listCustomers(){
    }
    public void gitCustomInBody(){
    }
}

