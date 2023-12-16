package Persons;


import Data.Gym;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * basic information about every person in the gym
 */
public abstract class Person {
    public int ID;
    public String Name, Address, PhoneNumber, Email,UserName, PassWord;
    public String gender;

    /**
     * takes a person information and create an object
     * @param id
     * @param name
     * @param gender
     * @param address
     * @param phone_number
     * @param email
     * @param uname
     * @param pass
     */
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