package Persons;
import Data.*;


public abstract  class Person{
    public int ID;
    public  String Name,Address,Phone_Number,Email;
    public Gender gender;
    public Person(int id,String name,Gender gender, String address,String phone_number,String email){
        ID=id;
        Name=name;
        this.gender=gender;
        Address=address;
        Phone_Number=phone_number;
        Email=email;
    }
} 