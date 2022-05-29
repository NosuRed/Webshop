package View;

import Controller.EmployeeController;
import Controller.IO;
import Controller.UserController;

import java.sql.SQLOutput;

public class UserLoginUI {

    private String name = null;

    private String lastName = null;

    private String houseNr = null;

    private String streetName = null;
    private String userName = null;
    private String userPassword = null;


    private String userInput = null;






    public void loginWindow() {
        System.out.println("Login");
        System.out.println("Please Enter Your Username Below: ");
        this.userName = IO.strInput();
        System.out.println("Please Enter Your Password Below: ");
        this.userPassword = IO.strInput();
        System.out.println("--------------------------------");

    }

    public void createCustomerUI(){
        System.out.println("Customer Account Creation");
        System.out.println("Please Enter Your Name: ");
        this.name = IO.strInput();
        System.out.println("Please Enter Your Lastname: ");
        this.lastName = IO.strInput();
        System.out.println("Please Enter Your House Number: ");
        this.houseNr = IO.strInput();
        System.out.println("Please Enter Your Street Name: ");
        this.streetName = IO.strInput();
        System.out.println("Please Enter An Accountname: ");
        this.userName = IO.strInput();
        System.out.println("Please Enter a Password: ");
        this.userPassword = IO.strInput();
        System.out.println("--------------------------------");
    }
    public void homePage(){
        System.out.println("WebShop");
        System.out.println("--------------------------------");
        System.out.println("For Login Enter L");
        System.out.println("To create A New Account Enter C");
        System.out.println("To  Exit The Webshop Enter X");
        System.out.println("--------------------------------");
        this.userInput = IO.strInput();
    }
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserInput() {
        return userInput.toLowerCase();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHouseNr() {
        return houseNr;
    }

    public String getStreetName() {
        return streetName;
    }
}
