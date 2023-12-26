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
        address = validatingInputs.inputString();
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
            uname = validatingInputs.inputString();
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
        pass = validatingInputs.inputString();

        Coach coach = null;
        while (true) {
            sub = getsub(id);
            coach = sub.getCoach();
            if(coach.Customers.size() <= 10 )
                break;
            System.out.println("Coach not available ");
        }
        Customer newCustomer = new Customer(id, name, gender, address, number, email, sub, uname, pass);
        Gym.Customers.add(newCustomer);
        coach.Customers.add(newCustomer);
        System.out.println("Customer record added.");
    }

    /**
     * delete customer by Id
     * @param customerId
     */
    public boolean deleteCustomer(int customerId) {
        Iterator<Customer> iterator = Gym.Customers.iterator();
        boolean found=false;
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getId() == customerId) {
                found=true;
                iterator.remove(); // Remove the customer with the matching ID
                System.out.println("Customer with ID " + customerId + " record deleted.");

                Iterator<Subscription> iterator2 = Gym.Subscriptions.iterator();
                while (iterator2.hasNext()) {
                    Subscription subscription = iterator2.next();
                    if (subscription == customer.subscription ) {
                        iterator2.remove(); // Remove the customer with the matching ID
                        return true; // Assuming each ID is unique, we can exit the loop after deletion
                    }
                }
                return true; // Assuming each ID is unique, we can exit the loop after deletion
            }
        }
        if (!found){
            System.out.println("There is no customer with this ID, please enter another ID");
        }
        return false;
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
        address = validatingInputs.inputString();
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
                for (Subscription subscription:Gym.Subscriptions){
                    if (subscription.coachID==coach.ID)
                        subscription.coachID=0;
                }
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
                        System.out.println("No Subscription history found.");
                    }
                }
            }
        }
    }
    /**
     *
     * displays all customers for a specific coach.
     */
    public void all_coach_customers() {
        Gym.displayCoaches();
        System.out.println("  ");
        System.out.println("Type the ID of the coach you wish to display their assigned customers: ");
        int id =validatingInputs.inputInteger();
        Coach coach = null;
        while(coach == null){
            coach = Gym.getCoach(id);
        }
        System.out.println("Customers assigned to " + coach.getName() + " :");
        coach.listCustomers();
    }

    /**
     *
     * @param date
     */
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

public void Edit() {
    int id,choice,key;
    String key1;
    System.out.println("Enter Id of customer to edit info");
    id = validatingInputs.inputInteger();
    for (Customer customer : Gym.Customers) {
        if (customer.ID == id) {
            System.out.println("Id:"+customer.ID);
            System.out.println("Name:"+customer.Name);
            System.out.println("Address:"+customer.Address);
            System.out.println("Phone Number:"+customer.PhoneNumber);
            System.out.println("Email:"+customer.Email);
            System.out.println("Username:"+customer.UserName);
            System.out.println("Password:"+customer.PassWord);
            System.out.println("Gender:"+customer.gender);
            System.out.println("What do you Want to edit?");
            System.out.println("1.Name");
            System.out.println("2.Address");
            System.out.println("3.Phone Number");
            System.out.println("4.Email");
            System.out.println("5.Username");
            System.out.println("6.Password");
            System.out.println("7.Gender");
            System.out.println("8.Back");
            choice = validatingInputs.inputInteger();
            if(choice==1){
                System.out.println("Enter new name");
                key1=scan.nextLine();
                customer.Name=key1;
                System.out.println("Data updated");
            }
            if(choice==2){
                System.out.println("Enter new address");
                key1=scan.nextLine();
                customer.Address=key1;
                System.out.println("Data updated");
            }
            if(choice==3){
                System.out.println("Enter new phone no.");
                key1=scan.nextLine();
                customer.PhoneNumber=key1;
                System.out.println("Data updated");
            }
            if(choice==4){
                System.out.println("Enter new Email");
                key1=scan.nextLine();
                customer.Email=key1;
                System.out.println("Data updated");
            }
            if(choice==5){
                System.out.println("Enter new username");
                key1=scan.nextLine();
                customer.UserName=key1;
                System.out.println("Data updated");
            }
            if(choice==6){
                System.out.println("Enter new password");
                key1=scan.nextLine();
                customer.PassWord=key1;
                System.out.println("Data updated");
            }
            if(choice==7){
                System.out.println("Enter new gender");
                key1=scan.nextLine();
                customer.gender=key1;
                System.out.println("Data updated");
            }
            if(choice==8){
                break;
            }
        }
    }
}
    public void edit_coaches() {
        int id,choice,key;
        String key1;
        System.out.println("Enter Id of coach to edit info");
        id = validatingInputs.inputInteger();
        for (Coach coach : Gym.Coaches) {
            if (coach.ID == id) {
                System.out.println("Id:"+coach.ID);
                System.out.println("Name:"+coach.Name);
                System.out.println("Address:"+coach.Address);
                System.out.println("Phone Number:"+coach.PhoneNumber);
                System.out.println("Email:"+coach.Email);
                System.out.println("Username:"+coach.UserName);
                System.out.println("Password:"+coach.PassWord);
                System.out.println("Gender:"+coach.gender);
                System.out.println("Working Hours:"+coach.getWorkingHours());
                System.out.println("Salary:"+coach.salary);
                System.out.println("What do you Want to edit?");
                System.out.println("1.Name");
                System.out.println("2.Address");
                System.out.println("3.Phone Number");
                System.out.println("4.Email");
                System.out.println("5.Username");
                System.out.println("6.Password");
                System.out.println("7.Gender");
                System.out.println("8.Working Hours");
                System.out.println("9.Salary");
                System.out.println("10.Back");
                choice = validatingInputs.inputInteger();
                if(choice==1){
                    System.out.println("Enter new name");
                    key1=scan.nextLine();
                    coach.Name=key1;
                    System.out.println("Data updated");
                }
                if(choice==2){
                    System.out.println("Enter new address");
                    key1=scan.nextLine();
                    coach.Address=key1;
                    System.out.println("Data updated");
                }
                if(choice==3){
                    System.out.println("Enter new phone no.");
                    key1=scan.nextLine();
                    coach.PhoneNumber=key1;
                    System.out.println("Data updated");
                }
                if(choice==4){
                    System.out.println("Enter new Email");
                    key1=scan.nextLine();
                    coach.Email=key1;
                    System.out.println("Data updated");
                }
                if(choice==5){
                    System.out.println("Enter new username");
                    key1=scan.nextLine();
                    coach.UserName=key1;
                    System.out.println("Data updated");
                }
                if(choice==6){
                    System.out.println("Enter new password");
                    key1=scan.nextLine();
                    coach.PassWord=key1;
                    System.out.println("Data updated");
                }
                if(choice==7){
                    System.out.println("Enter new gender");
                    key1=scan.nextLine();
                    coach.gender=key1;
                    System.out.println("Data updated");
                }
                if(choice==8){
                    System.out.println("Enter new working hours");
                    key=validatingInputs.inputInteger();
                    coach.setWorkingHours(key);
                    System.out.println("Data updated");
                }
                if(choice==9){
                    System.out.println("Enter new salary");
                    key=validatingInputs.inputInteger();
                    coach.salary=key;
                    System.out.println("Data updated");
                }
                if(choice==10){
                    break;
                }
            }
        }
    }
    public void edit_equipments() {
        int choice,key;
        String id,key1;
        System.out.println("Enter Id of customer to edit info");
        id = scan.nextLine();
        for (Equipment equipment : Gym.Equipments) {
            if (equipment.equals(id)) {
                System.out.println("Name:"+equipment.getName());
                System.out.println("Category:"+equipment.getCategory());
                System.out.println("Quantity:"+equipment.getQuantity());
                System.out.println("What do you Want to edit?");
                System.out.println("1.Name");
                System.out.println("2.Category");
                System.out.println("3.Quantity");
                System.out.println("4.Back");
                choice = validatingInputs.inputInteger();
                if(choice==1){
                    System.out.println("Enter new name");
                    key1=scan.nextLine();
                    equipment.setName(key1);
                    System.out.println("Data updated");
                }
                if(choice==2){
                    System.out.println("Enter new category");
                    key1=scan.nextLine();
                    equipment.setCategory(key1);
                    System.out.println("Data updated");
                }
                if(choice==3){
                    System.out.println("Enter new quantity");
                    key=validatingInputs.inputInteger();
                    equipment.setQuantity(key);
                    System.out.println("Data updated");
                }
                if(choice==4){
                    break;
                }
            }
        }
    }
}

