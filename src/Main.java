import java.util.*;

import Data.*;
import Persons.*;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        Gym gym = new Gym("Mommy Gym", "3and ommak", 69);
        readFile(gym);

        Admin admin = new Admin("admin", "pass");
        Gym.Admins.add(admin);

        // Main loop
        gym.DisplayGymInfo();

        while (true) {
            System.out.println("  Sign in as:  ");
            System.out.println("1. Admin  ");
            System.out.println("2. Customer  ");
            System.out.println("3. Coach  ");
            System.out.println("4. Exit  ");
            int key;
            key = scan.nextInt();
            if (key == 1) {

                boolean check;
                // admin loop
                if (key == 1) {
                    check = gym.signinadmin();

                    if (check) {
                        System.out.println("Access granted.");
                    } else {
                        System.out.println("Access denied.");
                        System.out.println("Wrong username or password, try again.");
                        continue;
                    }
                }
                while (true) {
                    System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                    System.out.println("  What would you like to access?");
                    System.out.println("1. Customers  ");
                    System.out.println("2. Coaches  ");
                    System.out.println("3. Equipments  ");
                    System.out.println("4. Other  ");
                    System.out.println("5. Back  ");
                    key = scan.nextInt();
                    if (key == 1) {
                        // customer option
                        while (true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            gym.displayCustomers();
                            System.out.println("1. Add Customer  ");
                            System.out.println("2. Delete Customer  ");
                            System.out.println("3. Back  ");
                            key = scan.nextInt();
                            if (key == 1) {
                                // add function
                                admin.AddCustomer();
                            } else if (key == 2) {
                                // delete function
                                System.out.println("Enter customer ID that you would like to delete: ");
                                key = scan.nextInt();
                                admin.deleteCustomer(key);
                            } else if (key == 3) {
                                // exit or back
                                break;
                            } else {
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }
                    } else if (key == 2) {
                        // Coaches option
                        while (true) {
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            gym.displayCoaches();
                            System.out.println("1. Add Coach  ");
                            System.out.println("2. Delete Coach  ");
                            System.out.println("3. Back  ");
                            key = scan.nextInt();
                            if (key == 1) {
                                // add function
                                admin.AddCoach();
                            } else if (key == 2) {
                                // delete function
                                System.out.println("Enter coach ID that you would like to delete: ");
                                key = scan.nextInt();
                                admin.deleteCoach(key);
                            } else if (key == 3) {
                                // exit or back
                                break;
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
                            key = scan.nextInt();
                            if (key == 1) {
                                // add function
                                admin.AddEquipment();
                            } else if (key == 2) {
                                // delete function
                                String skey;
                                System.out.println("Enter Equipment name that you would like to delete: ");
                                skey = scan.next();
                                admin.deleteEquipment(skey);
                            } else if (key == 3) {
                                // exit or back
                                break;
                            } else {
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
                            System.out.println("3. Show all susbcribed customers at a specific Date ");
                            System.out.println("4. Show total income ");
                            System.out.println("5. Add an Admin ");
                            System.out.println("6. Back");
                            key = scan.nextInt();
                            if (key == 1) {
                                // history function
                                String name;
                                gym.displayCustomers();
                                System.out.println("  ");
                                System.out.println(
                                        "Type the name of the customer you wish to display their subscription history: ");
                                name = scan.next();
                                admin.show_sub_history(name);
                            } else if (key == 2) {
                                // customer-coach function
                                String name;
                                gym.displayCoaches();
                                System.out.println("  ");
                                System.out.println(
                                        "Type the name of the coach you wish to display their assigned customers: ");
                                name = scan.next();
                                admin.all_coach_customers(name);
                            } else if (key == 3) {
                                // subscription-date function
                                String sdate;
                                System.out.println("  ");
                                System.out
                                        .println("Type the Date you wish to display all subscribed customers during: YYYY-MM-DD ");
                                sdate = scan.next();
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
                            } else {
                                System.out.println("Invalid entry, Try again.");
                                continue;
                            }
                        }
                    } else if (key == 5) {
                        // exit or back
                        break;
                    } else {
                        System.out.println("Invalid entry, Try again.");
                        continue;
                    }
                }
            } else if (key == 2) {
                // customer loop
                Customer customer;
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                customer = (Customer) signIn("customer");
                if (customer == null)
                    continue;
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
                    System.out.println("1. Print my customers ");
                    System.out.println("2. Get customer inbody history");
                    System.out.println("3. Get customer info ");
                    System.out.println("4. show list of male/female customers");
                    System.out.println("5. sign out");
                    key = scan.nextInt();
                    Customer customer;
                    switch (key) {
                        case 1:
                            coach.listCustomers();
                            break;
                        case 2:
                            System.out.print("Enter id: ");
                            try {
                                key = scan.nextInt();
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
                                key = scan.nextInt();
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
                            coach.listCustomersByGender(scan.next());
                            break;
                        case 5:
                            running = false;
                            break;
                        default:
                            continue;
                    }
                }
            } else if (key == 4) {
                // exit or back
                break;
            } else {
                System.out.println("Invalid entry, Try again.");
                continue;
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
            // TODO: handle exception
            System.out.println("no Couldn't read file");
        } catch (IOException e) {
            System.out.println("dCouldn't read file");
        } catch (ArrayIndexOutOfBoundsException c) {
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.println("date in the wrong format. should be yyyy-MM-dd");
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

                gym.Subscriptions.add(subscription);
            }
            br.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("cCouldn't read file");
        } catch (IOException e) {
            System.out.println("kCouldn't read file");
        } catch (ArrayIndexOutOfBoundsException c) {
        }

        // Read customers into gym's arraylist
        try {
            // parsing a CSV file into Scanner class constructor
            Scanner sc = new Scanner(new File("./src/files/Customer.csv"));
            sc.useDelimiter(","); // sets the delimiter pattern
            while (sc.hasNext()) // returns a boolean value
            {
                String trimmed_string = sc.next().trim();
                int customerId = Integer.parseInt(trimmed_string);
                String customerName = sc.next();
                String gender = sc.next();
                String address = sc.next();
                String number = sc.next();
                String email = sc.next();
                String uname = sc.next();
                String pass = sc.next();

                Subscription subscription = null;
                try {
                    for (Subscription sub : Gym.Subscriptions) {
                        if (sub.customerID == customerId)
                            subscription = sub;
                    }
                } catch (NullPointerException e) {
                    System.out.println("Couldn't find subscription");
                }

                Customer customer = new Customer(customerId, customerName, gender, address, number, email,
                        subscription, uname, pass);
                Gym.Customers.add(customer);

            }
            sc.close(); // closes the scanner
            // br.close();

        } catch (

        FileNotFoundException e) {
            // TODO: handle exception
            System.out.println("Couldn't read customer file");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ToDo sub array e");
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
        } catch (ArrayIndexOutOfBoundsException c) {
        } catch (ParseException e) {
            System.out.println("date in the wrong format. should be yyyy-MM-dd");
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
                                customer = sub.getCustomer(sub.customerID);
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
        boolean check = false;
        System.out.print("Username: ");
        username = scan.next();
        System.out.print("Password: ");
        password = scan.next();
        if (type.equals("customer")) {
            for (Customer cstmr : Gym.Customers) {
                if (cstmr.UserName.equals(username) && cstmr.PassWord.equals(password)) {
                    System.out.println("Access granted.");
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
        }
        System.out.println("Access denied.");
        System.out.println("Wrong username or password, try again.");
        return null;
    }
}