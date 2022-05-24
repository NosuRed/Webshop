package View;


import Controller.*;

import Model.*;

public class Main {

    public static void main(String[] args){

        Employee philipp = new Employee("Philipp", "Behrens", 5, "pBehrens","12345");
        EmployeeController ec = new EmployeeController();
        ArticleController ac = new ArticleController();
        Customer david = new Customer("David", "Behrens", 6, "dBehrens", "12345", "Hausnummer1", "Straße");
        Basket davidsBasket = new Basket(david);
        BasketController bc = new BasketController(davidsBasket);
        Article article = new Article(ac.generateArticleID(), 10,"Aepfel");
        Article article1 = new Article(ac.generateArticleID(),10,"Birne");

        ac.addArticle(article);
        ac.addArticle(article1);

        bc.addArticleToBasket(ac.getArticleByName("Birne"));


        bc.addArticleToBasket(ac.getArticleByName("Aepfel"));


        System.out.println(bc.articlesBoughtList());







    }

}


