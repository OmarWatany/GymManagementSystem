package Persons;
import java.util.Scanner;

import java.util.ArrayList;
import Data.*;
import Data.Subscription;
import java.util.Iterator;
import java.util.Date;

import static Data.Gender.FEMALE;
import static Data.Gender.MALE;

public class Admin {
    public String Username;
    public String Password;
    public String Name;
    Scanner scan = new Scanner(System.in);

    public Admin(String uname, String pass) {
        Username = uname;
        Password = pass;
    }

    public void AddCustomer() {
        int id;
        String name;
        Gender gender;
        String address;
        String number;
        String email;
        Subscription sub;
        System.out.println("  Enter Customer details");
        System.out.print("ID: ");
        id = scan.nextInt();
        System.out.print("Name: ");
        name = scan.next();
        while(true) {
        System.out.print("MALE or FEMALE: ");
        String Gcheck;
        Gcheck = scan.next();
            if (Gcheck.equals("male") || Gcheck.equals("MALE")) {
                gender = MALE;
                break;
            } else if (Gcheck.equals("female") || Gcheck.equals("FEMALE")) {
                gender = FEMALE;
                break;
            } else {
                System.out.println("Invalid entry, Try again.");
                continue;
            }
        }
        System.out.print("Address: ");
        address = scan.next();
        System.out.print("Phone Number: ");
        number = scan.next();
        System.out.print("email: ");
        email = scan.next();
        sub = getsub(id);
        Gym.Customers.add(new Customer(id , name, gender, address, number, email, sub));
        System.out.println("Customer record added.");
    }

    public void deleteCustomer( int customerId) {
        Iterator<Customer> iterator = Gym.Customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.customer_getId() == customerId) {
                iterator.remove(); // Remove the customer with the matching ID
                System.out.println("Customer with ID " + customerId + " record deleted.");
                return; // Assuming each ID is unique, we can exit the loop after deletion
            }
        }
    }
    public Subscription getsub(int id){
        int cid;
        System.out.println("Enter subscription detail... ");
        System.out.println("Coach ID: ");
        cid = scan.nextInt();
        Subscription newsub = new Subscription(id, cid);
        Gym.Subscriptions.add(newsub);
        return newsub;
    }

    public void AddCoach() {
        int id;
        String name;
        Gender gender;
        String address;
        String number;
        String email;
        int whours;
        int sal;
        System.out.println("  Enter Coach details");
        System.out.print("ID: ");
        id = scan.nextInt();
        System.out.print("Name: ");
        name = scan.next();
        while(true) {
            System.out.print("MALE or FEMALE");
            String Gcheck;
            Gcheck = scan.next();
            if (Gcheck.equals("male") || Gcheck.equals("MALE")) {
                gender = MALE;
                break;
            } else if (Gcheck.equals("female") || Gcheck.equals("FEMALE")) {
                gender = FEMALE;
                break;
            } else {
                System.out.println("Invalid entry, Try again.");
                continue;
            }
        }
        System.out.print("Address: ");
        address = scan.next();
        System.out.print("Phone Number: ");
        number = scan.next();
        System.out.print("email: ");
        email = scan.next();
        System.out.print("Working Hours: ");
        whours = scan.nextInt();
        System.out.print("Salary: ");
        sal = scan.nextInt();
        Gym.Coaches.add(new Coach(id, name, gender, address, number, email, whours,sal));
        System.out.println("Coach record added.");
    }

    public void deleteCoach( int coachId) {
        Iterator<Coach> iterator = Gym.Coaches.iterator();
        while (iterator.hasNext()) {
            Coach coach = iterator.next();
            if (coach.coach_getId() == coachId) {
                iterator.remove(); // Remove the customer with the matching ID
                System.out.println("Coach with ID " + coachId + " record deleted.");
                return; // Assuming each ID is unique, we can exit the loop after deletion
            }
        }
    }

    public void AddEquipment() {
        int quantity;
        String name;
        String category;
        System.out.println("  Enter Equipment details");
        System.out.print("Equipment name: ");
        name = scan.next();
        System.out.print("category: ");
        category = scan.next();
        System.out.print("Quantity: ");
        quantity = scan.nextInt();
        Gym.Equipments.add(new Equipment(name, category, quantity));
        System.out.println("Equipment record added.");
    }

    public void deleteEquipment(String name) {
        Iterator<Equipment> iterator = Gym.Equipments.iterator();
        while (iterator.hasNext()) {
            Equipment equipment = iterator.next();
            if (equipment.getName().equals(name)) {
                iterator.remove();
                System.out.println("Equipment with name " + name + " record deleted.");
                return;
            }
        }
    }

    public void show_sub_history(String cname){
        System.out.println("History: ");
        for (Customer customer : Gym.Customers) {
            if (customer.Name.equals(cname))
                System.out.println(customer.subscription.subscription_date);
        }
    }

    public void all_coach_customers(String cname){
        System.out.println("Customers assigned to "+cname+" :");
        for (Coach coach : Gym.Coaches) {
            if (coach.Name.equals(cname))
                for (int i =0;i<10;i++) {
                    if (Coach.customers[i] == null) {
                        break;
                    }

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
