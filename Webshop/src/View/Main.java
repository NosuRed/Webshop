package View;


import Controller.ArticleController;
import Controller.BasketController;
import Controller.EmployeeController;
import Model.Article;
import Model.Basket;
import Model.Customer;
import Model.Employee;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Employee philipp = new Employee("Philipp", "Behrens", 5, "pBehrens", "12345");

        ArticleController ac = new ArticleController();
        EmployeeController ec = new EmployeeController(ac, philipp);
        Customer david = new Customer("David", "Behrens", 6, "dBehrens", "12345", "Hausnummer1", "Straße");
        Basket davidsBasket = new Basket(david);
        BasketController bc = new BasketController(davidsBasket);

        Article article = new Article(ac.generateArticleID(), 10, "Birne");
        Article article3 = new Article(ac.generateArticleID(), 200, "Gameboy");
        Article article1 = new Article(ac.generateArticleID(), 10, "Aepfel");

        ec.addArticle(article);
        ec.addArticle(article3);
        ec.addArticle(article1);

        bc.addArticleToBasket(ac.getArticleByName("Birne"));


        bc.addArticleToBasket(ac.getArticleByName("Aepfel"));





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


    }

}


