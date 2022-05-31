package Controller;


import Model.Basket;
import Model.Customer;
import Model.Employee;
import Model.User;
import View.UserLoginUI;
import View.UserUI;
import persistence.FileWriteManager;

import java.io.IOException;

public class UserUIController {

    boolean logOut = true;
    private EmployeeController ec = null;
    private CustomerController cu = null;
    private UserLoginUI uLUI = null;

    public UserUIController(EmployeeController ec, CustomerController cu, UserLoginUI uLUI) {
        this.ec = ec;
        this.cu = cu;
        this.uLUI = uLUI;
    }

    public User empLogInCheck() {
        if (ec.getUserLoginList().contains(uLUI.getUserName() + "-" + uLUI.getUserPassword())) {
            for (int i = 0; i < ec.getUserList().size(); i++) {
                if (ec.getUserList().get(i).getUserName().equals(uLUI.getUserName()) && ec.getUserList().get(i).getPassword().equals(uLUI.getUserPassword())) {
                    ec.setEmployee((Employee) ec.getUserList().get(i));
                    return ec.getEmployeeModel();
                }
            }
        }
        return null;
    }

    public User cusLogInCheck() {
        if (cu.getUserLoginList().contains(uLUI.getUserName() + "-" + uLUI.getUserPassword())) {
            for (int i = 0; i < cu.getUserList().size(); i++) {
                if (cu.getUserList().get(i).getUserName().equals(uLUI.getUserName()) && cu.getUserList().get(i).getPassword().equals(uLUI.getUserPassword())) {
                    cu.setCustomer((Customer) cu.getUserList().get(i));
                    return cu.getCustomer();
                }
            }
        }
        return null;
    }


    private void employeeUI(UserUI userUI, EmployeeController employeeController, ArticleController articleController, CustomerController customerController, String articleFile, String employeeFile) {
        employeeController.setAc(articleController);
        switch (userUI.getUserInput().toUpperCase()) {
            case "A":
                System.out.println("Add a new Article:");
                System.out.println("Article Name: ");
                userUI.setUserInput();
                String articleName = userUI.getUserInput();
                System.out.println("Add The Amount Of Stock: ");
                userUI.setUserIntInput();
                int articleStock = userUI.getUserIntInput();
                System.out.println("Enter The Price of The Article");
                userUI.setUserInput();
                double articlePrice = Double.parseDouble(userUI.getUserInput());
                employeeController.addArticle(employeeController.createArticle(articleStock, articleName, articlePrice));
                break;

            case "E":
                System.out.println("Add A New Employee: ");
                System.out.println("Employee Name: ");
                // setUserInput -> "Name"
                userUI.setUserInput();
                //The name is saved in the variable name.
                String name = userUI.getUserInput();
                System.out.println("Employee Lastname: ");
                // setUserInput -> "Lastname
                userUI.setUserInput();
                //The Lastname is saved in the variable lastName.
                String lastName = userUI.getUserInput();
                System.out.println("Chose A Username: ");
                userUI.setUserInput();
                String userName = userUI.getUserInput();
                System.out.println("Create A Password: ");
                userUI.setUserInput();
                String password = userUI.getUserInput();
                employeeController.addUser(employeeController.createEmployee(name, lastName, userName, password));
                break;

            case "C":
                System.out.println("Adjust the Stock of an Article: ");
                System.out.println("Enter The Article Name");
                userUI.setUserInput();
                articleName = userUI.getUserInput();
                System.out.println("Enter How Much Stock To Add: ");
                userUI.setUserIntInput();
                int changeAmount = userUI.getUserIntInput();
                articleController.adjustStock(articleName, changeAmount);
                break;

            case "X":
                System.out.println("Log Out [X]");
                this.logOut = false;
                break;
            case "S":
                System.out.println("Articles: ");
                userUI.displayArticles(employeeController.getEmployeeModel());
                break;

            case "D":
                System.out.println("Employee List: ");
                userUI.displayAllEmployees(employeeController);
                break;
            case "F":
                System.out.println("Customer List: ");
                userUI.displayAllCustomers(customerController);
                break;
            case "SAVE":
                FileWriteManager.writeArticleData(articleFile, articleController);
                FileWriteManager.writeEmployeeData(employeeFile, employeeController);
                break;
            default:
                System.out.println("-1");
        }
    }

    public void login(UserLoginUI userLoginUI, UserUIController userUIController, ArticleController articleController, UserUI userUI, CustomerController customerController, String articleFile, EmployeeController employeeController, String employeeFile) throws IOException {
        userLoginUI.loginWindow();
        while (logOut) {

            if (userUIController.empLogInCheck() != null) {
                employeeController.setEmployee((Employee) userUIController.empLogInCheck());
                userUI.employeeHomePage();
                userUI.setUserInput();
                employeeUI(userUI, employeeController, articleController, customerController, articleFile, employeeFile);


                //User!
            } else if (userUIController.cusLogInCheck() != null) {
                customerController.setCustomer((Customer) userUIController.cusLogInCheck());
                Basket basket = new Basket(customerController.getCustomer());
                BasketController basketController = new BasketController(basket);
                userUI.userHomepage(customerController.getCustomer());
                if (userUI.getUserInput().equalsIgnoreCase("x")) {
                    this.logOut = false;
                } else if (userUI.getUserInput().equalsIgnoreCase("A") || userUI.getUserInput().equalsIgnoreCase("O")) {
                    articleController.sortArticlesInOrder(userUI.getUserInput());
                    userUI.displayArticles(customerController.getCustomer());
                    System.out.println("--------------------------------");

                } else if (userUI.getUserInput().equalsIgnoreCase("b")) {
                    basketChosen(userUI, basketController, articleController, articleFile);
                }

            } else {
                System.out.println("Account Not Found!");
                System.out.println("--------------------------------");

            }
        }
    }

    //TODO SWITCH CASE
    private void basketChosen(UserUI userUI, BasketController basketController, ArticleController articleController, String articleFile) throws IOException {
        boolean basketDone = true;

        while (basketDone) {
            userUI.basketHomePage();
            userUI.setUserInput();
            if (userUI.getUserInput().equalsIgnoreCase("a")) {
                System.out.println("Article Name: ");
                userUI.setUserInput();
                System.out.println("Enter How Much Stock You Want: ");
                userUI.setUserIntInput();

                basketController.addArticleToBasket(articleController.getArticleByName(userUI.getUserInput()));
                basketController.addArticle(userUI.getUserInput(), userUI.getUserIntInput());
                basketController.setStockAmount(userUI.getUserIntInput());

                basketContentBought(basketController, userUI);


            } else if (userUI.getUserInput().equalsIgnoreCase("B")) {
                FileWriteManager.writeArticleData(articleFile, articleController);
                basketController.articlesBought();
                basketController.emptyBasket();
                basketDone = false;

            } else if (userUI.getUserInput().equalsIgnoreCase("R")) {
                removeArticle(basketController, userUI);

            } else if (userUI.getUserInput().equalsIgnoreCase("C")) {

            } else if (userUI.getUserInput().equalsIgnoreCase("x")) {
                articleController.readData(articleFile);
                basketDone = false;

            }
        }
    }


    private void removeArticle(BasketController basketController, UserUI userUI) {
        userUI.setUserInput();
        basketController.deleteArticleFromBasket(userUI.getUserInput());
    }


    private void basketContentBought(BasketController basketController, UserUI userUI) {
        try {
            for (int i = 0; i < basketController.articlesBoughtList().size(); i++) {
                basketController.decreaseArticleStock(basketController.articlesBoughtList().get(i).getArtName(), userUI.getUserIntInput());
            }
            System.out.println(basketController.getBasketBoughtListDisplay());
            System.out.println(basketController.articlePriceSum());

        } catch (NullPointerException e) {
            System.out.println("This Article does not exist: " + e);
            System.out.println("--------------------------------");

        }
    }


}
