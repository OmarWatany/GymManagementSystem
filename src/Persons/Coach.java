package Persons;
import Data.*;

public class Coach extends Person {
    private int workingHours;
    public int salary;
    public static Customer[] customers = new Customer[10];
    public Coach(int id, String name, Gender gender, String address,
                 String number, String email, int workingHours,int salary){
        super(id,name,gender,address,number,email);
        this.workingHours = Math.min(workingHours, 10);
        this.salary=salary;
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
    public int coach_getId(){
        return ID;
    }
    public int getSalary(){
        return salary;
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