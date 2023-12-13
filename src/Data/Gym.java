package Data;

import Persons.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Gym {
    public String Name;
    public String Address;
    public int PhoneNumber;
    public static ArrayList<Coach> Coaches = new ArrayList<>();
    public static ArrayList<Subscription> Subscriptions = new ArrayList<>();
    public static ArrayList<Equipment> Equipments = new ArrayList<>();
    public static ArrayList<Customer> Customers = new ArrayList<>();
    public static ArrayList<Admin> Admins = new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    public Gym(String name, String address, int num) {
        Name = name;
        Address = address;
        PhoneNumber = num;
    }

    public void DisplayGymInfo() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("  welcome to " + Name);
        System.out.println("Our Address :  " + Address);
        System.out.println("Our Phone Number :  " + PhoneNumber);
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
    }

    public void AddCustomer(int id, String name, String gender, String address, String number, String email,
            Subscription subscription) {
        Customers.add(new Customer(id, name, gender, address, number, email, subscription));

    }

    public void displayCoaches() {
        System.out.println("Coaches:");
        for (Coach coach : Coaches) {
            System.out.println(coach.ID + "  " + coach.Name);
        }
        System.out.println("  ");
    }

    public void displaySubscriptions() {
        System.out.println("Subscriptions:");
        for (Subscription subscription : Subscriptions) {
            System.out.println(subscription);
        }
        System.out.println("  ");
    }

    public void displayEquipments() {
        System.out.println("Equipments:");
        for (Equipment equipment : Equipments) {
            System.out.println(equipment.getName());
        }
        System.out.println("  ");
    }

    public void displayCustomers() {
        System.out.println("Customers:");
        for (Customer customer : Customers) {
            System.out.println(customer.ID + "   " + customer.Name);
        }
        System.out.println("  ");
    }

    public static int gettotalprice() {
        int totalprice = 0;
        for (Subscription subscription : Subscriptions) {
            // totalprice += subscription.price;
        }
        return totalprice;
    }

    public static int gettotalsalary() {
        int totalsalary = 0;
        for (Coach coach : Coaches) {
            totalsalary += coach.salary;
            ;
        }
        return totalsalary;
    }
    public int adminsignin() {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("  Sign in:  ");
        String username;
        String password;
        int check=0;
        System.out.print("Username: ");
        username = scan.next();
        System.out.print("Password: ");
        password = scan.next();
        for (Admin admin : Admins) {
            if (admin.Username.equals(username) && admin.Password.equals(password)) {
                check++;
                break;
            }
        }
        return check;
    }

}