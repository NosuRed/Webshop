package Controller;

import Model.Article;
import Model.Employee;
import Model.User;


public class EmployeeController extends UserController {
    private ArticleController ac = null;




    public EmployeeController(ArticleController ac){
        this.ac = ac;
    }

    @Override
    public int generateUserID() {
        return super.generateUserID();
    }

    /**
     * add a new article
     *
     * @param model of the article
     */
    public void addArticle(Article model) {
        this.ac.addArticle(model);
    }

    @Override
    public void addUser(User user) {
        super.addUser(user);

    }


}
