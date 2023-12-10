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
        Subscription sub = new Subscription();
        Admin admin = new Admin("admin","pass","n");
        Gym gym = new Gym("Mommy Gym","3and ommak",69);
        gym.DisplayGymInfo();
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

        // admin functionality testing
        int key;
        key = scan.nextInt();
        if (key==1){
            gym.displayCustomers();
            key = scan.nextInt();
            if (key==1){
                admin.AddCustomer(789,"koky",FEMALE,"henak","1245677","email",sub);
                gym.displayCustomers();
            }
            else if (key==2){
                gym.displayCustomers();
                key = scan.nextInt();
                admin.deleteCustomer(key);
                gym.displayCustomers();
            }
        }

    }
}
