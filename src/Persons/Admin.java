package Persons;

import java.util.Scanner;

import Data.*;
import jdk.jshell.JShell;

import java.util.Iterator;
import java.util.Date;

// import static Data.Gender.FEMALE;
// import static Data.Gender.MALE;

public class Admin {
    public String Username;
    public String Password;

    Scanner scan = new Scanner(System.in);

    public Admin(String uname, String pass) {
        Username = uname;
        Password = pass;
    }
    public String getAllAttributes() {
            String attributes = "," + Username + "," + Password ;

            return attributes;
        }
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
        id = scan.nextInt();
        System.out.print("Name: ");
        name = scan.next();
        while (true) {
            System.out.print("MALE or FEMALE: ");
            String Gcheck;
            Gcheck = scan.next();
            if (Gcheck.equals("male") || Gcheck.equals("MALE")) {
                gender = "MALE";
                break;
            } else if (Gcheck.equals("female") || Gcheck.equals("FEMALE")) {
                gender = "FEMALE";
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
        System.out.print("UserName: ");
        uname = scan.next();
        System.out.print("PassWord: ");
        pass = scan.next();
        sub = getsub(id);
        Gym.Customers.add(new Customer(id, name, gender, address, number, email, sub,uname,pass));
        System.out.println("Customer record added.");
    }

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

    public Subscription getsub(int id) {
        int cid;
        System.out.println("Enter subscription detail... ");
        System.out.println("Coach ID: ");
        cid = scan.nextInt();
        Date date = new Date();
        MemberShipPlan mem = new MemberShipPlan(32,date,2,3,2342);
        Subscription newsub = new Subscription(id, cid,mem);
        Gym.Subscriptions.add(newsub);
        return newsub;
    }

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
        id = scan.nextInt();
        System.out.print("Name: ");
        name = scan.next();
        while (true) {
            System.out.print("MALE or FEMALE");
            String Gcheck;
            Gcheck = scan.next();
            if (Gcheck.equals("male") || Gcheck.equals("MALE")) {
                gender = "MALE";
                break;
            } else if (Gcheck.equals("female") || Gcheck.equals("FEMALE")) {
                gender = "FEMALE";
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
        System.out.print("UserName: ");
        uname = scan.next();
        System.out.print("PassWord: ");
        pass = scan.next();
        Gym.Coaches.add(new Coach(id, name, gender, address, number, email, whours, sal,uname,pass));
        System.out.println("Coach record added.");
    }

    public void deleteCoach(int coachId) {
        Iterator<Coach> iterator = Gym.Coaches.iterator();
        while (iterator.hasNext()) {
            Coach coach = iterator.next();
            if (coach.getId() == coachId) {
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

    public void show_sub_history(String cname) {
        System.out.println("History: ");
        for (Customer customer : Gym.Customers) {
            if (customer.Name.equals(cname) && customer.subscriptions.size() != 0){
                for(Subscription sub : customer.subscriptions){
                    System.out.println(sub.getPlan().startDate);
                }
            }
        }
    }

    public void all_coach_customers(String cname) {
        System.out.println("Customers assigned to " + cname + " :");
        for (Coach coach : Gym.Coaches) {
            if (coach.Name.equals(cname))
                for (int i = 0; i < 10; i++) {
                    if (coach.Customers.get(i) == null) {
                        break;
                    }

                    System.out.println(coach.Customers.get(i).Name);
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
        income = Gym.gettotalprice() - Gym.gettotalsalary();
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
