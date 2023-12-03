package Data;

public abstract  class Person{
    int ID;
    protected String Name,Gender,Address,Phone_Number,Email;
    public Person(int id,String name,String gender, String address,String phone_number,String email){
        ID=id;
        Name=name;
        Gender=gender;
        Address=address;
        Phone_Number=phone_number;
        Email=email;
    }
} 