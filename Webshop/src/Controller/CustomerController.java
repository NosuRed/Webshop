package Controller;

import Model.Customer;
import persistence.FileReadManager;

import java.io.IOException;

public class CustomerController extends UserController {

    FileReadManager readManager = new FileReadManager();
    private Customer customer;

    public void readData(String file) throws IOException {

        readManager.openForReading(file);
        Customer customer;

        do {
            customer = readManager.loadCustomer();
            if (customer != null) {
                addUser(customer);
            }
        } while (customer != null);

        readManager.closeReadManager();
    }

    public void  addUserLoginList(){
        super.addUserLoginList();
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int generateUserID() {
        return super.generateUserID();
    }

}
