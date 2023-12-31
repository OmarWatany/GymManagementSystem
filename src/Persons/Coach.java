package Persons;

import java.util.ArrayList;
import interfaces.*;
import Data.*;

public class Coach extends Person implements filewriting {
    private int workingHours;
    public int salary;
    public ArrayList<Customer> Customers = new ArrayList<>();

    public Coach(int id, String name, String gender, String address,
            String number, String email, int workingHours, int salary, String uname, String pass) {
        super(id, name, gender, address, number, email, uname, pass);
        this.workingHours = Math.min(workingHours, 10);
        this.salary = salary;
    }

    public String getAllAttributes() {
        String attributes = ","+String.valueOf(ID) + "," + Name + "," + gender + "," + Address + "," + PhoneNumber + ","
                + Email +","+workingHours+","+salary+ "," + UserName + "," + PassWord;
        return attributes;
    }

    public String getName() {
        return Name;
    }

    public void setWorkingHours(int wh) {
        workingHours = wh;
    }

    public int getWorkingHours() {
        System.out.println(workingHours);
        return workingHours;
    }

    public void listCustomers() {
        for (Customer cstmr : this.Customers) {
            try{
                System.out.println("Id: " + cstmr.getId() + "  ,Name :" + cstmr.Name);
            } catch (NullPointerException e){
                System.out.println("There isn't any customers." + e + " size " + this.Customers.size());
            }
        }
    }

    public void listCustomersByGender(String gender) {
        String igender = gender.toLowerCase();
        for (Customer cstmr : Customers) {
            if (cstmr.gender.toLowerCase().equals(igender))
                System.out.println("Id: " + cstmr.getId() + " ,Name :" + cstmr.Name);
        }
    }

    public Customer getCustomer(int id) {
        for (Customer cstmr : Customers) {
            if (cstmr.getId() == id)
                return cstmr;
        }
        return null;
    }

    public int getId() {
        return ID;
    }

    public int getSalary() {
        return salary;
    }

    public void getCustomerInBodyHistory(String name) {
        for (Customer customer : Customers) {
            if (customer != null && customer.Name.equals(name)) {
                for (InBody inbody : customer.inBodies) {
                    if (inbody != null)
                        inbody.displayInformation();
                }
            }
        }
    }

    public void getInfo(){
        System.out.println("Name : " + Name);
        System.out.println("Address  : " + Address ) ;
        System.out.println("PhoneNumber  : " + PhoneNumber ) ;
        System.out.println("Working Hours : " + workingHours);
    }

}