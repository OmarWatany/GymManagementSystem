package Data;

import Persons.Coach;

public class Gym {
    public String Name;
    public String Address;
    public int PhoneNumber;
    public Coach[] coaches = new Coach[10];
    public Subscription[] Subscriptions = new Subscription[10];
    public Equipment[] Equipments = new Equipment[50];

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