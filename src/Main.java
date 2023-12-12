import java.util.ArrayList;
import java.util.Date;

import Data.*;
import Persons.*;
import java.util.Date;
import static Data.Gender.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // for testing
        Scanner scan = new Scanner(System.in);
        Date date = new Date();
        Subscription sub = new Subscription(1234,2342);
        //Admin admin = new Admin("admin","pass");
        Gym gym = new Gym("Mommy Gym","3and ommak",69);
        Customer omar = new Customer(234,"omar",MALE,
                "234 st as","012351235","omar@email.com",sub);
        gym.Customers.add(omar);
        omar.inBodies[0] = new InBody(date,1.5F,15F,1F,10F,0.5F);
        omar.inBodies[1] = new InBody(date,1.2F,16F,1F,8F,0.8F);
        Coach ahmed = new Coach(23,"Ahmed",MALE,"23 Ahmed st",
                "012345678901","Ahmed@email.com",9,2000);
        gym.Coaches.add(ahmed);
        ahmed.customers[0] = omar;
       // ahmed.getCustomerInBodyHistory("omar");



        // Main loop
        gym.DisplayGymInfo();

        while(true){
            System.out.println("  Sign in as:  ");
            System.out.println("1. Admin  ");
            System.out.println("2. Customer  ");
            System.out.println("3. Coach  ");
            System.out.println("4. Exit  ");
            int key;
            key = scan.nextInt();
            if (key==1) {
                //admin loop
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
                System.out.println("  Sign in:  ");
                String username;
                String password;
                System.out.print("Username: ");
                username = scan.next();
                System.out.print("Password: ");
                password = scan.next();
                Admin admin = new Admin(username,password);
                System.out.println("Access granted.");
                while(true){
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
                    System.out.println("  What would you like to access?");
                    System.out.println("1. Customers  ");
                    System.out.println("2. Coaches  ");
                    System.out.println("3. Equipments  ");
                    System.out.println("4. Other  ");
                    System.out.println("5. Back  ");
                    key = scan.nextInt();
                    if (key==1) {
                        //customer option
                        while(true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
                            gym.displayCustomers();
                            System.out.println("1. Add Customer  ");
                            System.out.println("2. Delete Customer  ");
                            System.out.println("3. Back  ");
                            key = scan.nextInt();
                            if(key==1){
                                //add function
                                admin.AddCustomer();
                            }
                            else if(key==2) {
                                //delete function
                                System.out.println("Enter customer ID that you would like to delete: ");
                                key= scan.nextInt();
                                admin.deleteCustomer(key);
                            }
                            else if(key==3){
                                //exit or back
                                break;
                            }
                            else{
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }
                    }
                    else if (key == 2) {
                        //Coaches option
                        while(true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
                            gym.displayCoaches();
                            System.out.println("1. Add Coach  ");
                            System.out.println("2. Delete Coach  ");
                            System.out.println("3. Back  ");
                            key = scan.nextInt();
                            if(key==1){
                                //add function
                                admin.AddCoach();
                            }
                            else if(key==2) {
                                //delete function
                                System.out.println("Enter coach ID that you would like to delete: ");
                                key= scan.nextInt();
                                admin.deleteCoach(key);
                            }
                            else if(key==3){
                                //exit or back
                                break;
                            }
                            else{
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }

                    }
                    else if (key == 3) {
                        //Equipment option
                        while(true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
                            gym.displayEquipments();
                            System.out.println("1. Add Equipment  ");
                            System.out.println("2. Delete Equipment  ");
                            System.out.println("3. Back  ");
                            key = scan.nextInt();
                            if(key==1){
                                //add function
                                admin.AddEquipment();
                            }
                            else if(key==2) {
                                //delete function
                                String skey;
                                System.out.println("Enter Equipment name that you would like to delete: ");
                                skey= scan.next();
                                admin.deleteEquipment(skey);
                            }
                            else if(key==3){
                                //exit or back
                                break;
                            }
                            else{
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }
                    }
                    else if (key == 4) {
                        //other unrelated functions
                        while(true){
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
                            System.out.println("  Other functionality options: ");
                          //  System.out.println("  ");
                            System.out.println("1. Show subscription history of a specific customer ");
                            System.out.println("2. Show all customers assigned to a specific Coach ");
                            System.out.println("3. Show all susbcribed customers at a specific Date ");
                            System.out.println("4. Show total income ");
                            System.out.println("5. Back ");
                            key = scan.nextInt();
                            if (key==1){
                                // history function
                                String name;
                                gym.displayCustomers();
                                System.out.println("  ");
                                System.out.println("Type the name of the customer you wish to display their subscription history: ");
                                name = scan.next();
                                admin.show_sub_history(name);
                            }
                            else if(key==2){
                                //customer-coach function
                                String name;
                                gym.displayCoaches();
                                System.out.println("  ");
                                System.out.println("Type the name of the coach you wish to display their assigned customers: ");
                                name = scan.next();
                                admin.all_coach_customers(name);
                            }
                            else if(key==3){
                                //subscription-date function
                                String sdate;
                                System.out.println("  ");
                                System.out.println("Type the Date you wish to display all subscribed customers during: ");
                                sdate = scan.next();
                                admin.show_sub_date(sdate);
                            }
                            else if(key==4){
                                //income
                                admin.display_income();
                            }
                            else if(key==5){
                                //exit or back
                                break;
                            }
                            else{
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }

                    }
                    else if(key==5){
                        //exit or back
                        break;
                    }
                    else{
                        System.out.println("Invalid entry, Try again.");
                        continue;
                    }
                }
            }
            else if (key == 2) {
                //customer loop
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
            }
            else if (key == 3) {
                //coach loop
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-" );
            }
            else if(key==4){
                //exit or back
                break;
            }
            else{
                System.out.println("Invalid entry, Try again.");
                continue;
            }
        }
    }
}
