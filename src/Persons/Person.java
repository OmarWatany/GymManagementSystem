package Persons;

import Data.*;

import java.util.Scanner;

public abstract class Person {
    public int ID;
    public String Name, Address, PhoneNumber, Email,UserName, PassWord;
    public String gender;

    public Person(int id, String name, String gender, String address, String phone_number, String email,String uname,String pass) {
        ID = id;
        Name = name;
        this.gender = gender;
        Address = address;
        PhoneNumber = phone_number;
        Email = email;
        UserName = uname;
        PassWord = pass;
    }


}