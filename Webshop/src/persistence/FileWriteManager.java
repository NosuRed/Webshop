package persistence;

import Controller.ArticleController;
import Controller.CustomerController;
import Controller.EmployeeController;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriteManager {


    public static void writeArticleData(String file, ArticleController ac) {
        try {
            PrintWriter writer = new PrintWriter(file);
            for (int i = 0; i < ac.getAllArticles().size(); i++) {
                writer.println(ac.getAllArticles().get(i).getArtID());
                writer.println(ac.getAllArticles().get(i).getArtName());
                writer.println(ac.getAllArticles().get(i).getStock());
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
