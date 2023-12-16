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

    static float inputFloat(){
        Scanner scan = new Scanner(System.in);
        float key;
        while(true){
            try {
                key = scan.nextFloat();
                break;
            }
            catch (InputMismatchException e){
                System.out.println("Please enter a number");
            }
        }
        return key;
    }

    static String inputString(){
        Scanner scan = new Scanner(System.in);
        String line;
        while(true){
        line = scan.nextLine();
            if (line.contains(",")){
                System.out.println("can't use \",\" , please enter again");
            }
            else break;
        }
        return line;
    }

}
