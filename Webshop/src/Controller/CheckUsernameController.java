package Controller;

import Model.Customer;
import Model.Employee;


public class CheckUsernameController {

    private CustomerController cu = null;
    private EmployeeController ec = null;

    private Customer cusModel = null;

    private Employee employeeModel = null;


    public CheckUsernameController(CustomerController cu, EmployeeController ec) {
        this.cu = cu;
        this.ec = ec;
    }

    private boolean checkUserExistsInUsers() {

        for (int i = 0; i < cu.getUserList().size(); i++) {
            //Check if Customer username exists in the Customer
            if (cusModel != null) {
                if (cu.getUserList().get(i).getUserName().equals(cusModel.getUserName())) {
                    return true;

                }
            }
            else if (employeeModel != null) {
                if (cu.getUserList().get(i).getUserName().equals(employeeModel.getUserName())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkUserExistsInEmployees() {
        for (int i = 0; i < ec.getUserList().size(); i++) {
            if (employeeModel != null) {
                if (ec.getUserList().get(i).getUserName().equals(employeeModel.getUserName())) {
                    return true;

                }
            }
            else if (cusModel != null) {
                if (ec.getUserList().get(i).getUserName().equals(cusModel.getUserName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkUserExists() {
        return checkUserExistsInUsers() || checkUserExistsInEmployees();
    }

    public void setCusModel(Customer cusModel) {
        this.cusModel = cusModel;
    }

    public void setEmployeeModel(Employee employeeModel) {
        this.employeeModel = employeeModel;
    }
}
