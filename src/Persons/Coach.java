package Persons;

import java.util.ArrayList;

import Data.*;

public class Coach extends Person {
    private int workingHours;
    public int salary;
    public ArrayList<Customer> Customers=new ArrayList<>();

    public Coach(int id, String name, String gender, String address,
                 String number, String email, int workingHours, int salary,String uname,String pass) {
        super(id, name, gender, address, number, email,uname,pass);
        this.workingHours = Math.min(workingHours, 10);
        this.salary = salary;
    }

    public void getName() {
        System.out.println(Name);
    }

    public void setWorkingHours(int wh) {
        workingHours = wh;
    }

    public void getWorkingHours() {
        System.out.println(workingHours);
    }

    public void listCustomers() {
        for(Customer cstmr: Customers){
            System.out.println("Id: " + cstmr.getId() + "  ,Name :" +  cstmr.Name);
        }
    }

    public void listCustomersByGender(String gender) {
        String igender = gender.toLowerCase();
        for(Customer cstmr: Customers){
            if(cstmr.gender.toLowerCase().equals(igender))
                System.out.println("Id: " + cstmr.getId() + " ,Name :" +  cstmr.Name);
        }
    }

    public Customer getCustomer(int id){
        for(Customer cstmr: Customers){
            if(cstmr.getId() == id)
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
}