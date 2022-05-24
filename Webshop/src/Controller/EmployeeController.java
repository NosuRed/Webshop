package Controller;

import Model.Article;
import Model.User;


public class EmployeeController extends UserController {
    Article acModel = null;
    ArticleController ac = null;


    /**
     * add a new article
     *
     * @param model of the article
     * @param ac    the article controller
     */
    public void addArticle(Article model, ArticleController ac) {
        this.acModel = model;
        this.ac = ac;
        this.ac.addArticle(this.acModel);
    }

    @Override
    public void addUser(User user) {
        super.addUser(user);

    }


}
