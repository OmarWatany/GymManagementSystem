package Persons;

public abstract  class Person{
    public int ID;
    public  String Name,Gender,Address,Phone_Number,Email;
    public Person(int id,String name,String gender, String address,String phone_number,String email){
        ID=id;
        Name=name;
        Gender=gender;
        Address=address;
        Phone_Number=phone_number;
        Email=email;
    }
} 