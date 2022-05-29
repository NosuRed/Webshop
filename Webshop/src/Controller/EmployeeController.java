package Controller;

import Model.Article;
import Model.Employee;
import Model.User;
import persistence.FileReadManager;

import java.io.IOException;
import java.util.List;


public class EmployeeController extends UserController {
    FileReadManager readManager = new FileReadManager();
    private ArticleController ac = null;
    private Employee employeeModel = null;

    public void setAc(ArticleController ac) {
        this.ac = ac;
    }

    public Employee getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployee(Employee employee) {
        this.employeeModel = employee;
    }


    public void readData(String file) throws IOException {

        readManager.openForReading(file);
        Employee employee;

        do {
            employee = readManager.loadEmployees();
            if (employee != null) {
                addUser(employee);
            }
        } while (employee != null);

        readManager.closeReadManager();
    }


    @Override
    public void addUserLoginList() {
        super.addUserLoginList();
    }

    @Override
    public List<String> getUserLoginList() {
        return super.getUserLoginList();
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
