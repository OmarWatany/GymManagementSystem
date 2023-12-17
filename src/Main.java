import java.util.*;

import Data.*;
import Persons.*;
import interfaces.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main implements validatingInputs {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        Gym gym = new Gym("El Gym ", "5 Ali St ", "35836837");
        readFile(gym);

        // Main loop
        gym.DisplayGymInfo();

        while (true) {
            int key;
            System.out.println("  Sign in as:  ");
            System.out.println("1. Admin  ");
            System.out.println("2. Customer  ");
            System.out.println("3. Coach  ");
            System.out.println("4. Exit  ");
            key = validatingInputs.inputInteger();
            if (key == 1) {
                // admin loop
                Admin admin = gym.signinadmin();

                if (admin != null) {
                    System.out.println("Access granted.");
                } else {
                    System.out.println("Access denied.");
                    System.out.println("Wrong username or password, try again.");
                    continue;
                }
                while (true) {
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    System.out.println("  What would you like to access?");
                    System.out.println("1. Customers  ");
                    System.out.println("2. Coaches  ");
                    System.out.println("3. Equipments  ");
                    System.out.println("4. Other  ");
                    System.out.println("5. Back  ");
                    System.out.println("0. Exit");
                    key =validatingInputs.inputInteger();
                    if (key == 1) {
                        // customer option
                        gym.displayCustomers();
                        while (true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            System.out.println("1. Add Customer");
                            System.out.println("2. Edit customer  ");
                            System.out.println("3. Delete Customer  ");
                            System.out.println("4. Back  ");
                            System.out.println("0. Exit");
                            key =validatingInputs.inputInteger();
                            if (key==1){
                                admin.AddCustomer();
                            }
                            else if (key == 2) {
                                // edit function
                            } else if (key == 3) {
                                // delete function
                                System.out.println("Enter customer ID that you would like to delete: ");
                                key =validatingInputs.inputInteger();
                                admin.deleteCustomer(key);
                            } else if (key == 4) {
                                // exit or back
                                break;
                            } else if (key==0) {
                                writeCSVFile(gym);
                                System.exit(0);
                            } else {
                                System.out.println("Invalid entry, Try again.");

                            }
                        }
                    } else if (key == 2) {
                        // Coaches option
                        while (true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            System.out.println("1. Display Coaches");
                            System.out.println("2. Add Coach  ");
                            System.out.println("3. Delete Coach  ");
                            System.out.println("4. Back  ");
                            System.out.println("0. Exit");
                            key = validatingInputs.inputInteger();
                            if (key==1){
                                Gym.displayCoaches();
                            } else if (key == 2) {
                                // add function
                                admin.AddCoach();
                            } else if (key == 3) {
                                // delete function
                                boolean found=false;
                                System.out.println("Enter coach ID that you would like to delete: ");
                                while(!found){
                                key =validatingInputs.inputInteger();
                                found=admin.deleteCoach(key);
                                }
                            } else if (key == 4) {
                                // exit or back
                                break;
                            } else if (key==0) {
                                writeCSVFile(gym);
                                System.exit(0);
                            } else {
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }

                    } else if (key == 3) {
                        // Equipment option
                        while (true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            gym.displayEquipments();
                            System.out.println("1. Add Equipment  ");
                            System.out.println("2. Delete Equipment  ");
                            System.out.println("3. Back  ");
                            System.out.println("0. Exit");
                            key =validatingInputs.inputInteger();
                            if (key == 1) {
                                // add function
                                admin.AddEquipment();
                            } else if (key == 2) {
                                // delete function
                                String skey;
                                System.out.println("Enter Equipment name that you would like to delete: ");
                                skey = scan.nextLine();
                                admin.deleteEquipment(skey);
                            } else if (key == 3) {
                                // exit or back
                                break;
                            }else if (key==0) {
                                writeCSVFile(gym);
                                System.exit(0);
                            }  else {
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }
                    } else if (key == 4) {
                        // other unrelated functions
                        while (true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            System.out.println("  Other functionality options: ");
                            // System.out.println(" ");
                            System.out.println("1. Show subscription history of a specific customer ");
                            System.out.println("2. Show all customers assigned to a specific Coach ");
                            System.out.println("3. Show all subscribed customers at a specific Date ");
                            System.out.println("4. Show total income ");
                            System.out.println("5. Add an Admin ");
                            System.out.println("6. Back");
                            System.out.println("0. Exit");
                            key =validatingInputs.inputInteger();
                            if (key == 1) {
                                // history function
                                gym.displayCustomers();
                                System.out.println("  ");
                                System.out.println("Type the ID of the customer you wish to display their subscription history: ");
                                key =validatingInputs.inputInteger();
                                admin.show_sub_history(key);
                            } else if (key == 2) {
                                // customer-coach function
                                admin.all_coach_customers();
                            } else if (key == 3) {
                                // subscription-date function
                                String sdate;
                                System.out.println("  ");
                                System.out .println("Type the Date you wish to display all subscribed customers during: YYYY-MM-DD ");
                                sdate = scan.nextLine();
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                try {
                                    Date startDate = dateFormat.parse(sdate);
                                    admin.show_sub_date(startDate);
                                } catch(NullPointerException e){
                                    System.out.println("Date " + e);
                                } catch (ParseException e) {
                                    throw new RuntimeException(e);
                                }

                            } else if (key == 4) {
                                // income
                                admin.display_income();
                            } else if (key == 5) {
                                admin.addadmin();
                            } else if (key == 6) {
                                // exit or back
                                break;
                            }else if (key==0) {
                                writeCSVFile(gym);
                                System.exit(0);
                            }  else {
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }
                    } else if (key == 5) {
                        // exit or back
                        break;
                    }else if (key==0) {
                        writeCSVFile(gym);
                        System.exit(0);
                    }  else {
                        System.out.println("Invalid entry, Try again.");
                    }
                }
            } else if (key == 2) {
                // customer loop
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                Customer customer = (Customer) signIn("customer");
                if (customer == null)
                    continue;
                while(key != 6){
                    System.out.println("1. Get coach info");
                    System.out.println("2. Display Gym Equipment.");
                    System.out.println("3. Display membership plan details.");
                    System.out.println("4. Display the in-body information at a specific date.");
                    System.out.println("5. Display how many kilos need to be reduced according to inBody");
                    System.out.println("6. Sign Out");
                    System.out.println("0. Exit");
                    key =validatingInputs.inputInteger();
                    switch (key){
                        case 1:
                            customer.getCoach().getInfo();
                            break;
                        case 2:
                            gym.displayEquipments();
                            break;
                        case 3:
                            try {
                                customer.getPlan().displayInfo();
                            } catch (NullPointerException e){
                                System.out.println("error " + e);
                                continue;
                            }
                            break;
                        case 4:
                            System.out .print("Data YYYY-MM-DD :  ");
                            String sdate = scan.next();
                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            try {
                                Date Date = dateFormat.parse(sdate);
                                customer.get_InBody(Date);
                            } catch(NullPointerException e){
                                System.out.println("Date " + e);
                                continue;
                            } catch (ParseException e) {
                                System.out.println("Invalid format" + e);
                                continue;
                            }
                            break;
                        case 5:
                            customer.inBodies.getLast().getWeightControl(customer);
                            break;
                        case 0:
                            writeCSVFile(gym);
                            System.exit(0);
                            break;
                    }
                }
            } else if (key == 3) {
                Coach coach;
                // coach loop
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                coach = (Coach) signIn("coach");
                if (coach == null)
                    continue;
                boolean running = true;
                while (running) {
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    System.out.println("  What would you like to do?");
                    System.out.println("1. Display my customers ");
                    System.out.println("2. Get customer inbody history");
                    System.out.println("3. Get customer info ");
                    System.out.println("4. show list of male/female customers");
                    System.out.println("5. sign out");
                    System.out.println("0. Exit");
                    key =validatingInputs.inputInteger();
                    Customer customer;
                    switch (key) {
                        case 1:
                            coach.listCustomers();
                            break;
                        case 2:
                            System.out.print("Enter id: ");
                            try {
                                key =validatingInputs.inputInteger();
                            } catch (InputMismatchException e) {
                                System.out.println("Please Enter valid number");
                                continue;
                            }
                            try {
                                coach.getCustomer(key).printInBodyHistory();
                            } catch (NullPointerException e) {
                                System.out.println("Couldn't find any");
                                continue;
                            }
                            break;
                        case 3:
                            System.out.print("Enter id: ");
                            try {
                                key =validatingInputs.inputInteger();
                            } catch (InputMismatchException e) {
                                System.out.println("Please Enter valid number");
                                continue;
                            }
                            try {
                                coach.getCustomer(key).getInfo();
                            } catch (NullPointerException e) {
                                System.out.println("Couldn't find any");
                                continue;
                            }
                            break;
                        case 4:
                            System.out.print("Gender : ");
                            coach.listCustomersByGender(scan.nextLine());
                            break;
                        case 5:
                            running = false;
                            break;
                        case 0:
                            writeCSVFile(gym);
                            System.exit(0);
                            break;
                    }
                }
            } else if (key == 4) {
                // exit or back
                break;
            } else {
                System.out.println("Invalid entry, Try again.");
            }
        }
        writeCSVFile(gym);
        scan.close();
    }

    public static void readFile(Gym gym) {

        // Read memplans into gym's arraylist
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("./src/files/membershipPlans.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] values = line.split(","); // use comma as separator

                int planId = Integer.parseInt(values[1]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date startDate = dateFormat.parse(values[2]);
                int monthlyPlan = Integer.parseInt(values[3]);
                int numOfMonthsRegistered = Integer.parseInt(values[4]);
                float price = Float.parseFloat(values[5]);

                MemberShipPlan membershipPlan = new MemberShipPlan(planId, startDate, monthlyPlan,
                        numOfMonthsRegistered, price);
                Gym.MemberShipPlans.add(membershipPlan);
            }
            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("couldn't read membership file");
        } catch (IOException e) {
            System.out.println("dCouldn't read file");
        } catch (ArrayIndexOutOfBoundsException c) {
            System.out.println("array ex"+c);
        } catch (ParseException e) {
            System.out.println("date in the wrong format. should be yyyy-MM-dd");
        } catch(NumberFormatException e){
            System.out.println("membership file " + e);
        }

        // Read subscriptons into gym's arraylist
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("./src/files/Subscription.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] values = line.split(","); // use comma as separator

                int customerID = Integer.parseInt(values[1]);
                int coachID = Integer.parseInt(values[2]);
                int membershipId = Integer.parseInt(values[3]);

                MemberShipPlan membershipPlan = null;
                    for (MemberShipPlan mem : Gym.MemberShipPlans) {
                        if (mem.planId == membershipId)
                            membershipPlan = mem;
                    }
                    if (membershipPlan == null)
                        System.out.println("Couldn't find any plan");

                Subscription subscription = new Subscription(customerID, coachID, membershipPlan);

                Gym.Subscriptions.add(subscription);
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("cCouldn't read file");
        } catch (IOException e) {
            System.out.println("kCouldn't read file");
        } catch (ArrayIndexOutOfBoundsException c) {
        } catch(NumberFormatException e){
            System.out.println("subscription file " + e);
        }

        // Read customers into gym's arraylist
        try {
            // parsing a CSV file into Scanner class constructor
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("./src/files/Customer.csv"));
            String[] values ;
            while ((line = br.readLine()) != null && line.length() > 1) // returns a boolean value
            {
                values = line.split(",");
                int customerId = Integer.parseInt(values[1]);
                String customerName = values[2];
                String gender =       values[3];
                String address =      values[4];
                String number =       values[5];
                String email =        values[6];
                String uname =        values[7];
                String pass =         values[8];

                Subscription subscription = null;
                for (Subscription sub : Gym.Subscriptions) {
                    if (sub.customerID == customerId)
                        subscription = sub;
                }

                Customer customer = new Customer(customerId, customerName, gender, address, number, email,
                        subscription, uname, pass);

                Gym.Customers.add(customer);
            }
             br.close();
        } catch ( FileNotFoundException e) {
            System.out.println("Couldn't read customer file");
        } catch(NumberFormatException e){
            System.out.println("customers file " + e);
        } catch (IOException e) {
            System.out.println("customer io : " + e);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Array out of boundry" + e);
        }

        // Read Inbodies into customers' arraylist
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("./src/files/InBody.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] values = line.split(","); // use comma as separator

                int customerId = Integer.parseInt(values[1]);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = dateFormat.parse(values[2]);
                // Parse the string to a Date object

                float height = Float.parseFloat(values[3]);
                float fatMass = Float.parseFloat(values[4]);
                float minerals = Float.parseFloat(values[5]);
                float bodyWater = Float.parseFloat(values[6]);
                float protein = Float.parseFloat(values[7]);

                InBody inBody = new InBody(customerId, date, height, fatMass, minerals, bodyWater, protein);
                for (int i = 0; i < Gym.Customers.size(); i++) {
                    if (Gym.Customers.get(i).ID == customerId)
                        Gym.Customers.get(i).inBodies.add(inBody);
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't read inbody file" + e);
        } catch (IOException e) {
            System.out.println("inbody io : " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" array out of boundry : " + e);
        } catch (ParseException e) {
            System.out.println("date in the wrong format. should be yyyy-MM-dd");
        } catch(NumberFormatException e){
            System.out.println("inbody file " + e);
        }

        // Read coaches into gym
        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("./src/files/Coach.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] values = line.split(","); // use comma as separator
                int coachId = Integer.parseInt(values[1]);
                String coachName = values[2];
                String gender = values[3];
                String address = values[4];
                String number = values[5];
                String email = values[6];
                int workingHours = Integer.parseInt(values[7]);
                int salary = Integer.parseInt(values[8]);
                String uname = values[9];
                String pass = values[10];

                Coach coach = new Coach(coachId, coachName, gender, address, number, email, workingHours, salary, uname,
                        pass);

                Gym.Coaches.add(coach);

                // adding customers
                Customer customer = null;
                try {
                    for (Subscription sub : Gym.Subscriptions) {
                        if (sub.coachID == coachId)
                            try {
                                customer = sub.getCustomer();
                                coach.Customers.add(customer);
                            } catch (NullPointerException e) {
                                System.out.println("Couldn't find customer");
                            }
                    }
                } catch (NullPointerException e) {
                    System.out.println("Couldn't find subscription");
                }

            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("Couldn't read Coaches file");
        } catch (IOException e) {
            System.out.println("Coaches io : " + e);
        } catch (ArrayIndexOutOfBoundsException c) {
        } catch(NumberFormatException e){
            System.out.println("coach file " + e);
        }

        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("./src/files/Equipment.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] values = line.split(","); // use comma as separator
                String name = values[1];
                String category = values[2];
                int quantity = Integer.parseInt(values[3]);
                Equipment equipment = new Equipment(name, category, quantity);
                Gym.Equipments.add(equipment);
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("Couldn't read Equipment");
        } catch (IOException e) {
            System.out.println("Equipment io e" + e);
        } catch (ArrayIndexOutOfBoundsException c) {
        }

        try {
            String line = "";
            BufferedReader br = new BufferedReader(new FileReader("./src/files/Admin.csv"));
            while ((line = br.readLine()) != null) // returns a Boolean value
            {
                String[] values = line.split(","); // use comma as separator
                String username = values[1];
                String password = values[2];
                Gym.Admins.add(new Admin(username, password));
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("Couldn't read Admin file");
        } catch (IOException e) {
            System.out.println("Admin io exeption " + e);
        } catch (ArrayIndexOutOfBoundsException c) {
        }
    }

    public static void writeCSVFile(Gym gym) {
        // Write customers
        try {
            FileWriter csvWriter = new FileWriter("./src/files/Customer.csv");
            for (int i = 0; i < Gym.Customers.size(); i++) {
                csvWriter.append(",");
                csvWriter.append(String.valueOf(Gym.Customers.get(i).ID));
                csvWriter.append(",");
                csvWriter.append(Gym.Customers.get(1).Name);
                csvWriter.append(",");
                csvWriter.append(Gym.Customers.get(i).gender);
                csvWriter.append(",");
                csvWriter.append(Gym.Customers.get(i).Address);
                csvWriter.append(",");
                csvWriter.append(Gym.Customers.get(i).PhoneNumber);
                csvWriter.append(",");
                csvWriter.append(Gym.Customers.get(i).Email);
                csvWriter.append(",");
                csvWriter.append(Gym.Customers.get(i).UserName);
                csvWriter.append(",");
                csvWriter.append(Gym.Customers.get(i).PassWord);
                csvWriter.append(",");
                if (i < Gym.Customers.size() - 1) {
                    csvWriter.append("\n");
                }
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("File not found , please double check the file path");
        }
        // Write coaches
        try {
            FileWriter csvWriter = new FileWriter("./src/files/Coach.csv");
            for (Coach coach : Gym.Coaches) {
                csvWriter.append(coach.getAllAttributes());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File not found , please double check the file path");
        }
        // write Subscription
        try {
            FileWriter csvWriter = new FileWriter("./src/files/Subscription.csv");
            for (Subscription subscription : Gym.Subscriptions) {
                csvWriter.append(subscription.getAllAttributes());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File not found , please double check the file path");
        }

        // write Equipment
        try {
            FileWriter csvWriter = new FileWriter("./src/files/Equipment.csv");
            for (Equipment equipment : Gym.Equipments) {
                csvWriter.append(equipment.getAllAttributes());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File not found , please double check the file path");
        }
        // write Admin
        try {
            FileWriter csvWriter = new FileWriter("./src/files/Admin.csv");
            for (Admin admin : Gym.Admins) {
                csvWriter.append(admin.getAllAttributes());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File not found , please double check the file path");
        }
        // write Membership
        try {
            FileWriter csvWriter = new FileWriter("./src/files/membershipPlans.csv");
            for (MemberShipPlan memberShipPlan : Gym.MemberShipPlans) {
                csvWriter.append(memberShipPlan.getAllAttributes());
                csvWriter.append("\n");
            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File not found , please double check the file path");
        }
        // NOT YET WORKING
        // write InBody

        try {
            FileWriter csvWriter = new FileWriter("./src/files/InBody.csv");
            for (Customer customer : Gym.Customers) {
                for (InBody inbody : customer.inBodies) {
                    csvWriter.append(inbody.getAllAttributes());
                    csvWriter.append("\n");
                }

            }
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            // TODO: handle exception
            System.out.println("File not found , please double check the file path");
        }

    }

    public static Person signIn(String type) {
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
        System.out.println("  Sign in:  ");
        String username;
        String password;
        System.out.print("Username: ");
        username = validatingInputs.inputString();
        System.out.print("Password: ");
        password = validatingInputs.inputString();
        if (type.equals("customer")) {
            for (Customer cstmr : Gym.Customers) {
                // there is a problem with the password check
                // username works fine
                if (cstmr.UserName.equals(username) && cstmr.PassWord.equals(password.trim())) {
                    System.out.println("Access granted.");
                    System.out.println("pass: " + cstmr.PassWord);
                    return cstmr;
                }
            }
        } else if (type.equals("coach")) {
            for (Coach coach : Gym.Coaches) {
                if (coach.UserName.equals(username) && coach.PassWord.equals(password)) {
                    System.out.println("Access granted.");
                    return coach;
                }
            }
        } else {
            System.out.println("error");
        }
        System.out.println("Access denied.");
        System.out.println("Wrong username or password, try again.");
        return null;
    }
}