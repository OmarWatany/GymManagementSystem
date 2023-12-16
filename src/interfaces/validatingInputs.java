package interfaces;

import java.util.InputMismatchException;
import java.util.Scanner;

public interface validatingInputs {
    static int inputInteger(){
        Scanner scan = new Scanner(System.in);
        int key;
        while(true){
            try {
                key = scan.nextInt();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a number");
                scan.nextLine();
            }
        }
        return key;
    }
    static String inputAddress(){
        Scanner scan = new Scanner(System.in);
        String address;
        while(true){
        address = scan.next();
            if (address.contains(",")){
                System.out.println("Address can't contain \",\" inside  , please enter it again");
            }
            else break;
        }
        return address;
    }

}
