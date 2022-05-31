package View;

import Controller.*;
import Model.Basket;
import Model.Customer;
import Model.User;

import java.util.ArrayList;

public class UserUI {

    private String userInput = null;
    private ArticleController ac = null;


    private int userIntInput = -1;

    public UserUI(ArticleController ac) {
        this.ac = ac;
    }

    public void userHomepage(Customer customer) {
        System.out.println("Welcome: " + customer.getName());
        System.out.println("--------------------------------");
        displayArticles(customer);
        System.out.println("--------------------------------");
        System.out.println("To Logout Enter X! ");
        System.out.println("Display Articles Alphabetically: Enter A! Display Articles In Order Enter O! ");
        System.out.println("To Add Articles to your Basket Enter B!");
        this.userInput = IO.strInput();
        System.out.println("--------------------------------");
    }


    public void basketHomePage() {
        System.out.println("--------------------------------");
        System.out.println("Add OR Decrease An Article by Entering A!");
        System.out.println("To Buy Enter B!");
        System.out.println("To Remove An Article Enter R and then Enter the Article Name!");
        System.out.println("To Exit Your Basket Press X");
        System.out.println("--------------------------------");
    }

    public void  userBillUI(ArrayList<String> arrayList, double price){
        System.out.println("--------------------------------");
        System.out.println("Artikels Bought:");
        System.out.println(arrayList);
        System.out.println("Total Price: " + price);
        System.out.println("--------------------------------");

    }


    public void employeeHomePage() {
        System.out.println("--------------------------------");
        System.out.println("Employee UI");
        System.out.println("--------------------------------");
        System.out.println("Add A New Article [A]");
        System.out.println("Add A New Employee [E]");
        System.out.println("Change Article Stock Amount [C]");
        System.out.println("Show All Articles [S]");
        System.out.println("Display All Employees [D]");
        System.out.println("Display All Customers [F]");
        System.out.println("To Save [Save]");
        System.out.println("Logout [X]");
        System.out.println("--------------------------------");
    }


    public String getUserInput() {
        return userInput;
    }


    public void setUserInput() {
        this.userInput = IO.strInput();
    }

    public void setUserIntInput() {
        this.userIntInput = IO.intInput();
    }

    public int getUserIntInput() {
        return userIntInput;
    }

// TODO use formate for the output
    public void displayArticles(User user) {
        for (int i = 0; i < ac.getAllArticles().size(); i++) {
            if (!(user.isEmployee())) {
                System.out.println(ac.getAllArticles().get(i).getArtName() + " | Stock: " + ac.getAllArticles().get(i).getStock() +" | Price: " + ac.getAllArticles().get(i).getPrice() );
            } else {
                System.out.println(ac.getAllArticles().get(i).getArtName() + " | Stock: " + ac.getAllArticles().get(i).getStock() + " | ID: " + ac.getAllArticles().get(i).getArtID() +" | Price " + ac.getAllArticles().get(i).getPrice());
            }

        }
    }


    public void displayAllEmployees(EmployeeController employeeController) {
        for (User user : employeeController.getUserList()) {
            System.out.printf("Name:%s | Lastname:%s | Username:%s | userID:%s | IsEmployee:%s%n", user.getName(), user.getLastName(), user.getUserName(), user.getIdNum(), user.isEmployee());
        }

    }

    public void displayAllCustomers(CustomerController customerController) {
        for (User user : customerController.getUserList()) {
            System.out.printf("Name:%s | Lastname:%s | Username:%s | userID:%s | IsEmployee:%s | House-number:%s | Street name:%s %n", user.getName(), user.getLastName(), user.getUserName(), user.getIdNum(), user.isEmployee(), user.getHouseNr(), user.getStreetName());
        }

    }
}
