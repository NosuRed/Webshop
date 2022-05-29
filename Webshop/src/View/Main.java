package View;


import Controller.*;
import Model.Article;
import Model.Customer;
import persistence.FileReadManager;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {


        ArticleController articleController = new ArticleController();
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();
        FileReadManager fileReadManager = new FileReadManager();
        UserLoginUI userLoginUI = new UserLoginUI();
        UserLoginController userLoginController = new UserLoginController(employeeController, customerController, userLoginUI);
        CheckUsernameController cuc = new CheckUsernameController(customerController, employeeController);
        CustomerUI customerUI = new CustomerUI(articleController);

        Article article = new Article(articleController.generateArticleID(), 2, "Bteak");
        Article article1 = new Article(articleController.generateArticleID(), 10, "Aish");

        Customer dummyCustomer = new Customer("Philipp", "Behrens", customerController.generateUserID(),"pBehrens", "12345","12b","Streethome");
        customerController.addUser(dummyCustomer);
        customerController.addUserLoginList();

        articleController.addArticle(article);
        articleController.addArticle(article1);

        boolean stopProgramm = true;
        boolean logOut = true;
        userLoginUI.homePage();
        while (stopProgramm) {


            if (userLoginUI.getUserInput().equals("c")) {
                userLoginUI.createCustomerUI();
                Customer customer = new Customer(userLoginUI.getName(), userLoginUI.getLastName(), customerController.generateUserID(), userLoginUI.getUserName(), userLoginUI.getUserPassword(), userLoginUI.getHouseNr(), userLoginUI.getStreetName());
                cuc.setCusModel(customer);
                if ((!cuc.checkUserExists())) {
                    customerController.addUser(customer);
                    customerController.addUserLoginList();
                    System.out.println("Account Created! Please Log In! ");
                    userLoginUI.homePage();
                } else {
                    System.out.println("Something went wrong lol");
                }
            }

            if (userLoginUI.getUserInput().equals("l")) {
                userLoginUI.loginWindow();


                if (userLoginController.empLogInCheck() != null) {
                    System.out.println("employee UI");

                } else if (userLoginController.cusLogInCheck() != null) {

                    customerController.setCustomer((Customer) userLoginController.cusLogInCheck());
                    while(logOut) {
                        customerUI.userHomepage(customerController.getCustomer());
                        if(customerUI.getUserInput().equalsIgnoreCase("x")){
                            logOut = false;
                            userLoginUI.homePage();
                        }else{
                            articleController.sortArticlesInOrder(customerUI.getUserInput());
                            customerUI.displayArticles();
                        }

                    }
                } else {
                    System.out.println("Account Not Found!");
                    System.out.println("--------------------------------");
                    userLoginUI.homePage();

                }
            } else if (userLoginUI.getUserInput().equals("x")) {
                stopProgramm = false;
            } else {
                userLoginUI.homePage();
            }


        }
    }


}




