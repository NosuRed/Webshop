package View;


import Controller.ArticleController;
import Controller.CustomerController;
import Controller.EmployeeController;
import Model.Article;
import Model.Customer;
import Model.Employee;
import persistence.FileWriteManager;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {



        ArticleController ac = new ArticleController();
        EmployeeController ec = new EmployeeController(ac);
        CustomerController cc = new CustomerController();





        for (int i = 0; i < 20 ; i++) {
            Employee philipp1 = new Employee("Philipp", "Behrens", ec.generateUserID(), "pBehrens", "12345");
            Customer david1 = new Customer("David", "Behrens", cc.generateUserID(), "dBehrens", "12345", "Hausnummer1", "Straße");
            cc.addUser(david1);
            ec.addUser(philipp1);
            System.out.println(ec.getUserID(philipp1));
            System.out.println(cc.getUserID(david1));
            System.out.println(ec.getUserList().get(i).getUserName());

        }


        Article article = new Article(ac.generateArticleID(), 10, "Birne");
        Article article3 = new Article(ac.generateArticleID(), 200, "Gameboy");
        Article article1 = new Article(ac.generateArticleID(), 10, "Aepfel");

        ec.addArticle(article);
        ec.addArticle(article3);
        ec.addArticle(article1);
        for (int i = 0; i < 20; i++) {
            Article art = new Article(ac.generateArticleID(), 5, "A");
            ec.addArticle(art);
        }
        Article test = new Article(ac.generateArticleID(),1000,"bob");
        ec.addArticle(test);
        List<Article> articleList = ac.sortArticlesInOrder("A");
        System.out.println(articleList.size());
        for (int i = 0; i <articleList.size() ; i++) {
            System.out.println(articleList.get(i).getArtName() + " " + articleList.get(i).getArtID());
        }

        FileWriteManager.writeData("Test.txt", ac);
        FileWriteManager.writeEmployeeData("Employee.txt", ec);
        FileWriteManager.writeCustomerData("Customer.txt", cc);

    }

}


