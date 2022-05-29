package View;

import Controller.ArticleController;
import Controller.IO;
import Model.Customer;

public class CustomerUI {

    private String userInput = null;
    private ArticleController ac = null;

    public CustomerUI(ArticleController ac){
        this.ac = ac;
    }
    public void userHomepage(Customer customer){
        System.out.println("Welcome: " + customer.getName());
        System.out.println("To Logout Enter X! ");
        System.out.println("Display Articles Alphabetically: Enter A! Display Articles In Order Enter O! ");
        this.userInput = IO.strInput();
    }

    public String getUserInput() {
        return userInput;
    }

    public void displayArticles(){
        for (int i = 0; i < ac.getAllArticles().size(); i++) {
            System.out.println(ac.getAllArticles().get(i).getArtName() + " | Stock: " + ac.getAllArticles().get(i).getStock());
        }

    }
}
