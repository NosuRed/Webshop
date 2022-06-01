package persistence;

import Controller.ArticleController;
import Controller.BasketController;
import Controller.CustomerController;
import Controller.EmployeeController;
import Model.Article;

import java.io.*;

public class FileWriteManager {


    public static void writeArticleData(String file, ArticleController ac) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < ac.getAllArticles().size(); i++) {
                writer.println(ac.getAllArticles().get(i).getArtID());
                writer.println(ac.getAllArticles().get(i).getArtName());
                writer.println(ac.getAllArticles().get(i).getStock());
                writer.println(ac.getAllArticles().get(i).getPrice());
                writer.println(ac.getAllArticles().get(i).getLastChanged());
                writer.println(ac.getAllArticles().get(i).getStackSize());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeCustomerData(String file, CustomerController cc) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < cc.getUserList().size(); i++) {
                writer.println(cc.getUserList().get(i).getName());
                writer.println(cc.getUserList().get(i).getLastName());
                writer.println(cc.getUserList().get(i).getIdNum());
                writer.println(cc.getUserList().get(i).getHouseNr());
                writer.println(cc.getUserList().get(i).getStreetName());
                writer.println(cc.getUserList().get(i).getUserName());
                writer.println(cc.getUserList().get(i).getPassword());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeLog(String file, EmployeeController ec, ArticleController ac, String articleName) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter writer = new PrintWriter(bw);
            for (Article article : ac.getAllArticles()) {
                if (article.getArtName().equalsIgnoreCase(ac.getArticleByName(articleName).getArtName())) {
                    writer.println("Name " + ec.getEmployeeModel().getName());
                    writer.println("Lastname " + ec.getEmployeeModel().getLastName());
                    writer.println("ID: " + ec.getEmployeeModel().getIdNum());
                    writer.println("Article  " + ac.getArticleByName(articleName).getArtName());
                    writer.println("Stock: " + ac.getArticleByName(articleName).getStock());
                    writer.println("StackSize: " + ac.getArticleByName(articleName).getStackSize());
                    writer.println("Employee: " + ec.getEmployeeModel().isEmployee());
                    writer.println("Date: " + article.getLastChanged());
                }
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeLog(String file, CustomerController customerController, ArticleController ac, BasketController basketController) {
        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter writer = new PrintWriter(bw);
            for (Article article : basketController.articlesBoughtList()) {
                writer.println("Name: " + customerController.getCustomer().getName());
                writer.println("Lastname: " + customerController.getCustomer().getLastName());
                writer.println("ID:  " + customerController.getCustomer().getIdNum());
                writer.println("Employee: " + customerController.getCustomer().isEmployee());
                writer.println("Article: " + basketController.getBasketBoughtListDisplay());
                //writer.println("Stock Size " + basketController.getBasketBoughtListDisplay());
                writer.println("Date: " + article.getLastChanged());
            }
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeEmployeeData(String file, EmployeeController ec) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < ec.getUserList().size(); i++) {
                writer.println(ec.getUserList().get(i).getName());
                writer.println(ec.getUserList().get(i).getLastName());
                writer.println(ec.getUserList().get(i).getIdNum());
                writer.println(ec.getUserList().get(i).getUserName());
                writer.println(ec.getUserList().get(i).getPassword());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
