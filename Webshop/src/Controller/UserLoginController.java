package Controller;

import Model.Customer;
import Model.Employee;
import Model.User;
import View.UserLoginUI;

public class UserLoginController {
    private EmployeeController ec = null;
    private CustomerController cu = null;
    private UserLoginUI uLUI = null;

    public UserLoginController(EmployeeController ec, CustomerController cu, UserLoginUI uLUI) {
        this.ec = ec;
        this.cu = cu;
        this.uLUI = uLUI;
    }

    public Employee empLogInCheck() {
        if (ec.getUserLoginList().contains(uLUI.getUserName() + "-" + uLUI.getUserPassword())) {
            for (int i = 0; i < ec.getUserList().size(); i++) {
                if (ec.getUserList().get(i).getUserName().equals(uLUI.getUserName()) && ec.getUserList().get(i).getPassword().equals(uLUI.getUserPassword())) {
                    ec.setEmployee((Employee) ec.getUserList().get(i));
                    return ec.getEmployeeModel();
                }
            }
        }
        return null;
    }

    public User cusLogInCheck() {
        if (cu.getUserLoginList().contains(uLUI.getUserName() + "-" + uLUI.getUserPassword())) {
            for (int i = 0; i < cu.getUserList().size(); i++) {
                if (cu.getUserList().get(i).getUserName().equals(uLUI.getUserName()) && cu.getUserList().get(i).getPassword().equals(uLUI.getUserPassword())) {
                    cu.setCustomer((Customer) cu.getUserList().get(i));
                    return cu.getCustomer();
                }
            }
        }
        return null;
    }

}
