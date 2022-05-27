package Controller;

import Model.Article;
import Model.Employee;
import Model.User;


public class EmployeeController extends UserController {
    private ArticleController ac = null;

    private Employee employee = null;


    public EmployeeController(ArticleController ac, Employee employee){
        this.ac = ac;
        this.employee = employee;
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

    public Employee getEmployee(){
        return this.employee;
    }

}
