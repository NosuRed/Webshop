package Controller;

import Model.Article;
import Model.User;

import java.util.List;
import java.util.Vector;

public class EmployeeController extends UserController {
    Article acModel = null;
    ArticleController ac = null;


    public void addArticle(Article model, ArticleController ac){
        this.acModel = model;
        this.ac = ac;
        this.ac.addArticle(this.acModel);
    }


    @Override
    public void addUser(User user) {
        super.addUser(user);
    }



}
