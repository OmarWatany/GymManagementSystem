package Persons;

import java.util.Scanner;
import Data.*;
import java.util.Iterator;
import java.util.Date;
import interfaces.*;

/**
 * Gym Administrator who can access the data and modify it
 */
public class Admin implements validatingInputs  {
    public String Username;
    public String Password;

    Scanner scan = new Scanner(System.in);

    /**
     *  create admin object
     * @param uname
     * USERNAME
     * @param pass
     * PASSWORD
     */
    public Admin(String uname, String pass) {
        Username = uname;
        Password = pass;
    }
    public String getAllAttributes() {
        String attributes = "," + Username + "," + Password ;

        return attributes;
    }

    /**
     * Add customer to gym
     * takes data in runtime and adds the customer to the gym data
     */
    public void AddCustomer() {
        int id;
        String name;
        String gender;
        String address;
        String number;
        String email;
        String uname;
        String pass;
        Subscription sub;
        System.out.println("  Enter Customer details");
        System.out.print("ID: ");
        while(true){
            boolean found=false;
            id =validatingInputs.inputInteger();
            for (Customer customer: Gym.Customers){
                if (customer.ID==id){
                    found=true;
                    break;
                }
            }
            if (found){
                System.out.println("This ID is taken, please enter another one");
            }
            else break;
        }
        System.out.print("Name: ");
        name = scan.next();
        while (true) {
            System.out.print("MALE or FEMALE: ");
            String Gcheck;
            Gcheck = scan.next();
            if (Gcheck.equalsIgnoreCase("male") || Gcheck.equalsIgnoreCase("MALE")) {
                gender = "MALE";
                break;
            } else if (Gcheck.equalsIgnoreCase("female") || Gcheck.equalsIgnoreCase("FEMALE")) {
                gender = "FEMALE";
                break;
            } else {
                System.out.println("Invalid entry, Try again.");
                continue;
            }
        }
        System.out.print("Address: ");
        address = validatingInputs.inputAddress();
        System.out.print("Phone Number: ");
        while(true) {
            number = scan.next();
            if (number.matches("[0-9]+")){
                break;
            }
            else{
                System.out.println("Please enter a valid phone number");
            }
        }
        System.out.print("email: ");
        email = scan.next();
        while(true){
            boolean found=false;
            System.out.print("UserName: ");
            uname = scan.next();
            for (Customer customer: Gym.Customers){
                if (customer.UserName.equals(uname)){
                    found=true;
                    break;
                }
            }
            if (found){
                System.out.println("This Username  is taken, please enter another one");
            }
            else break;
        }
        System.out.print("Password: ");
        pass = scan.next();
        sub = getsub(id);
        Gym.Customers.add(new Customer(id, name, gender, address, number, email, sub,uname,pass));
        System.out.println("Customer record added.");
    }

    /**
     * delete customer by Id
     * @param customerId
     */
    public void deleteCustomer(int customerId) {
        Iterator<Customer> iterator = Gym.Customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId() == customerId) {
                iterator.remove(); // Remove the customer with the matching ID
                System.out.println("Customer with ID " + customerId + " record deleted.");
                return; // Assuming each ID is unique, we can exit the loop after deletion
            }
        }
    }

    /**
     * add subscription
     * @param id
     * @return
     */
    public Subscription getsub(int id) {
        int cid;
        System.out.println("Enter subscription details... ");
        Gym.displayCoaches();
        System.out.println("Coach ID: ");
        while(true){
            boolean found=false;
            cid =validatingInputs.inputInteger();
            for (Coach coach: Gym.Coaches){
                if (coach.ID==cid){
                    found=true;
                    break;
                }
            }
            if (!found){
                System.out.println("There is no Coach with this ID , please enter another ID");
            }
            else break;
        }
        Date date = new Date();
        MemberShipPlan mem = new MemberShipPlan(7,date,2,3,2342);
        Subscription newsub = new Subscription(id, cid,mem);
        Gym.Subscriptions.add(newsub);
        return newsub;
    }

    /**
     * Add coach
     */
    public void AddCoach() {
        int id;
        String name;
        String gender;
        String address;
        String number;
        String email;
        String uname;
        String pass;

        int whours;
        int sal;
        System.out.println("  Enter Coach details");
        System.out.print("ID: ");
        while(true){
            boolean found=false;
            id =validatingInputs.inputInteger();
            for (Coach coach: Gym.Coaches){
                if (coach.ID==id){
                    found=true;
                    break;
                }
            }
            if (found){
                System.out.println("This ID is taken, please enter another one");
            }
            else break;
        }
        System.out.print("Name: ");
        name = scan.next();
        while (true) {
            System.out.print("MALE or FEMALE: ");
            String Gcheck;
            Gcheck = scan.next();
            if (Gcheck.equalsIgnoreCase("male") || Gcheck.equalsIgnoreCase("MALE")) {
                gender = "MALE";
                break;
            } else if (Gcheck.equalsIgnoreCase("female") || Gcheck.equalsIgnoreCase("FEMALE")) {
                gender = "FEMALE";
                break;
            } else {
                System.out.println("Invalid entry, Try again.");
                continue;
            }
        }
        System.out.print("Address: ");
        address = validatingInputs.inputAddress();
        System.out.print("Phone Number: ");
        while(true) {
            number = scan.next();
            if (number.matches("[0-9]+")){
                break;
            }
            else{
                System.out.println("Please enter a valid phone number");
            }
        }
        System.out.print("email: ");
        email = scan.next();
        System.out.print("Working Hours Per week: ");
        whours =validatingInputs.inputInteger();
        System.out.print("Salary: ");
        sal =validatingInputs.inputInteger();
        while(true){
            boolean found=false;
            System.out.print("UserName: ");
            uname = scan.next();
            for (Coach coach: Gym.Coaches){
                if (coach.UserName.equals(uname)){
                    found=true;
                    break;
                }
            }
            if (found){
                System.out.println("This Username  is taken, please enter another one");
            }
            else break;
        }

        System.out.print("Password: ");
        pass = scan.next();
        Gym.Coaches.add(new Coach(id, name, gender, address, number, email, whours, sal,uname,pass));
        System.out.println("Coach record added.");
    }

    /**
     * delete coach by id
     * @param coachId
     */
    public boolean deleteCoach(int coachId) {
        Iterator<Coach> iterator = Gym.Coaches.iterator();
        boolean found=false;
        while (iterator.hasNext()) {
            Coach coach = iterator.next();
            if (coach.getId() == coachId) {
                found=true;
                iterator.remove(); // Remove the customer with the matching ID
                System.out.println("Coach with ID " + coachId + " record deleted.");
                return true; // Assuming each ID is unique, we can exit the loop after deletion
            }
        }
        if (!found){
            System.out.println("There is no coach with this ID, please enter another ID");
        }
        return false;
    }

    /**
     * add new equipment information to the gym data
     */
    public void AddEquipment() {
        int quantity;
        String name;
        String category;
        System.out.println("  Enter Equipment details");
        System.out.print("Equipment name: ");
        name = scan.nextLine();
        System.out.print("category: ");
        category = scan.nextLine();
        System.out.print("Quantity: ");
        quantity =validatingInputs.inputInteger();
        Gym.Equipments.add(new Equipment(name, category, quantity));
        System.out.println("Equipment record added.");
    }

    /**
     * dalete equipment information by name
     * @param name
     */
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

    /**
     * prints customer subscription history
     * @param id
     * customer id
     */
    public void show_sub_history(int id) {
        System.out.println("History: ");
        for (Customer customer : Gym.Customers) {
            if (customer.ID==id && customer.subscriptions.size() != 0){
                for(Subscription sub : customer.subscriptions){
                    if(sub!=null) {
                        System.out.println(sub.getPlan().startDate);
                    }
                    else{
                        System.out.println("No Subscription history found");
                    }
                }
            }
        }
    }

    /**
     *
     * @param cname
     */
    public void all_coach_customers(String cname) {
        System.out.println("Customers assigned to " + cname + " :");
        for (Coach coach : Gym.Coaches) {
            if (coach.Name.equals(cname)) {
                for (int i = 1; i <= 10; i++) {
                    if (coach.Customers.get(i) == null) {
                        break;
                    }
                    System.out.println(coach.Customers.get(i).Name);
                }
            }
        }
    }

    public void show_sub_date(Date date) {
        for (Customer customer : Gym.Customers) {
            if (customer.subscription.getPlan().equals(date))
                System.out.println(customer.Name);
        }
    }

    public void display_income() {
        int income;
        income = Gym.gettotalprice() - Gym.getTotalSalary();
        System.out.println("total income = " + income);
    }
    public void addadmin(){
        String username;
        String password;
        System.out.println(" ");
        System.out.println("Enter new Admin username: ");
        username = scan.next();
        System.out.println("Enter new Admin password: ");
        password = scan.next();
        Gym.Admins.add(new Admin(username,password));
    }


}
