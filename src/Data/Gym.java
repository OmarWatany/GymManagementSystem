package Data;

import Persons.Coach;
import java.util.ArrayList;

public class Gym {
    public String Name;
    public String Address;
    public int PhoneNumber;

    public ArrayList<Coach> coaches = new ArrayList<>();
    public ArrayList<Subscription> Subscriptions = new ArrayList<>();
    public ArrayList<Equipment> Equipments = new ArrayList<>();

    public Gym(String name,String address,int num){
        Name = name;
        Address = address;
        PhoneNumber=num;
    }
    public void DisplayGymInfo(){
        System.out.println("  welcome to " +Name);
        System.out.println("Our Address :  " +Address);
        System.out.println("Our Phone Number :  " +PhoneNumber);
    }


}