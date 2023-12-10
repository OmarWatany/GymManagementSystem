package Persons;

import java.util.ArrayList;
import Data.*;
import Data.Subscription;
import java.util.Iterator;
import java.util.Date;

public class Admin {
    public String Username;
    public String Password;
    public String Name;

    public Admin(String uname, String pass, String name) {
        Username = uname;
        Password = pass;
        Name = name;
    }

    public void AddCustomer( int id, String name, Gender gender, String address, String number, String email, Subscription subscription) {
        Gym.Customers.add(new Customer(id, name, gender, address, number, email, subscription));
        System.out.println("Customer added.");
    }

    public void deleteCustomer( int customerId) {
        Iterator<Customer> iterator = Gym.Customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.customer_getId() == customerId) {
                iterator.remove(); // Remove the customer with the matching ID
                System.out.println("Customer with ID " + customerId + " deleted.");
                return; // Assuming each ID is unique, we can exit the loop after deletion
            }
        }
    }

    public void AddCoach( int id, String name, Gender gender, String address,
                         String number, String email, int workingHours,int salary) {
        Gym.Coaches.add(new Coach(id, name, gender, address, number, email, workingHours,salary));
        System.out.println("Coach added.");
    }

    public void deleteCoach( int coachId) {
        Iterator<Coach> iterator = Gym.Coaches.iterator();
        while (iterator.hasNext()) {
            Coach coach = iterator.next();
            if (coach.coach_getId() == coachId) {
                iterator.remove(); // Remove the customer with the matching ID
                System.out.println("Coach with ID " + coachId + " deleted.");
                return; // Assuming each ID is unique, we can exit the loop after deletion
            }
        }
    }

    public void AddEquipment(String name, String category, int quantity) {
        Gym.Equipments.add(new Equipment(name, category, quantity));
        System.out.println("Equipment added.");
    }

    public void deleteEquipment(String name) {
        Iterator<Equipment> iterator = Gym.Equipments.iterator();
        while (iterator.hasNext()) {
            Equipment equipment = iterator.next();
            if (equipment.getName().equals(name)) {
                iterator.remove();
                System.out.println("Equipment with name " + name + " deleted.");
                return;
            }
        }
    }

    public void show_sub_history(Customer customer){
        System.out.println(customer.subscription.subscription_date);
    }

    public void all_coach_customers(String cname){
        System.out.println("Coaches:");
        for (Coach coach : Gym.Coaches) {
            if (coach.Name.equals(cname))
                for (int i =0;i<10;i++){
                System.out.println(Coach.customers[i].Name);
            }
        }
    }

    public void show_sub_date(String date){
        for (Customer customer : Gym.Customers) {
            if (customer.subscription.subscription_date.equals(date))
                    System.out.println(customer.Name);

        }
    }

    public void display_income(){
        int income;
        income=Gym.gettotalprice()-Gym.gettotalsalary();
        System.out.println("total income = "+income);
    }


}
