package Persons;

import Data.*;

public class Coach extends Person {
    private int workingHours;
    public Customer[] customers = new Customer[10];
    public Coach(int id, String name, String gender, String address,
                 String number, String email, int workingHours){
        super(id,name,gender,address,number,email);
        this.workingHours = Math.min(workingHours, 10);
    }
    public void getName(){
        System.out.println(Name);
    }
    public void setWorkingHours(int wh){
        workingHours = wh;
    }
    public void getWorkingHours(){
        System.out.println(workingHours);
    }
    public void listCustomers(){
    }

    public void getCustomerInBodyHistory(String name){
        for(Customer customer : customers ){
            if(customer != null && customer.Name.equals(name)){
                for (InBody inbody : customer.inBodies){
                    if(inbody != null)
                        inbody.displayInformation();
                }
            }
        }
    }
}