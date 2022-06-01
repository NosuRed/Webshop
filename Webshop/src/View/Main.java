package View;


import Controller.*;
import Model.Customer;
import persistence.FileWriteManager;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

        String articleFile = "Articles.txt";
        String employeeFile = "Employee.txt";
        String customerFile = "Customer.txt";
        String logFile = "Logfile.txt";

        ArticleController articleController = new ArticleController();
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();
        CheckUsernameController cuc = new CheckUsernameController(customerController, employeeController);
        UserUI userUI = new UserUI(articleController);

        articleController.readData(articleFile);
        employeeController.readData(employeeFile);
        customerController.readData(customerFile);

        customerController.addUserLoginList();
        employeeController.addUserLoginList();


        boolean stopProgramm = true;
        start(stopProgramm, customerController, cuc, articleController, userUI, employeeController, articleFile, employeeFile, logFile);
        FileWriteManager.writeArticleData(articleFile, articleController);
        FileWriteManager.writeCustomerData(customerFile, customerController);
        FileWriteManager.writeEmployeeData(employeeFile, employeeController);

    }

    public static void start(boolean stopProgramm, CustomerController customerController, CheckUsernameController cuc, ArticleController articleController, UserUI userUI, EmployeeController employeeController, String articleFile, String employeeFile, String logFile) throws IOException {

        while (stopProgramm) {
            UserLoginUI userLoginUI = new UserLoginUI();
            UserUIController userUIController = new UserUIController(employeeController, customerController, userLoginUI);

            userLoginUI.homePage();
            userLoginUI.setUserInput(IO.strInput());

            switch (userLoginUI.getUserInput()) {
                case "c":
                    userLoginUI.createCustomerUI();
                    Customer customer = new Customer(userLoginUI.getName(), userLoginUI.getLastName(), customerController.generateUserID(), userLoginUI.getUserName(), userLoginUI.getUserPassword(), userLoginUI.getHouseNr(), userLoginUI.getStreetName());
                    cuc.setCusModel(customer);

                    if ((!cuc.checkUserExists())) {
                        customerController.addUser(customer);
                        customerController.addUserLoginList();
                        System.out.println("Account Created! Please Log In! ");
                        userLoginUI.homePage();
                    } else {
                        System.out.println("Username: >>" + userLoginUI.getUserName() + "<< Is Already Taken!");
                        userLoginUI.homePage();
                    }
                    break;

                case "l":
                    userUIController.login(userLoginUI, userUIController, articleController, userUI, customerController, articleFile, employeeController, employeeFile, logFile);
                    break;
                case "x":
                    stopProgramm = false;
                    break;
                default:
                    userLoginUI.homePage();

            }


        }
    }

}




