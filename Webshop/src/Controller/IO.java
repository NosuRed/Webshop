package Controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class IO {


    public static String strInput(){
        Scanner userInput = new Scanner(System.in);
        return userInput.next();
    }

    public static int intInput() {
        Scanner userInput = new Scanner(System.in);
        try {
            int uI = userInput.nextInt();

            return uI;
        }catch (InputMismatchException e){
            System.out.println("Please input an Integer!");
            return -1;
        }

    }

}
