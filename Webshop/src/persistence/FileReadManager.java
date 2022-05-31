package persistence;

import Model.Article;
import Model.Customer;
import Model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadManager {

    private BufferedReader reader = null;

    public void openForReading(String file) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(file));
    }

    public Article loadArticle() throws IOException {
        try {
            int artID = Integer.parseInt(readData());
            String artName = readData();
            int artStock = Integer.parseInt(readData());
            double artPrice = Double.parseDouble(readData());
            return new Article(artID, artStock, artName, artPrice);
        } catch (NumberFormatException e) {
            return null;
        }


    }

    public Employee loadEmployees() throws IOException {
        try {
            String empName = readData();
            String empLastName = readData();
            int empID = Integer.parseInt(readData());
            String empUserName = readData();
            String empPassword = readData();
            return new Employee(empName, empLastName, empID, empUserName, empPassword);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Customer loadCustomer() throws IOException {
        try {
            String cName = readData();
            String cLastName = readData();
            int cID = Integer.parseInt(readData());
            String cHouseNum = readData();
            String cStreetName = readData();
            String cUserName = readData();
            String cPassword = readData();
            return new Customer(cName, cLastName, cID, cUserName, cPassword, cHouseNum, cStreetName);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String readData() throws IOException {
        if (reader != null) {
            return reader.readLine();
        } else {
            return "";
        }
    }


    public void closeReadManager() throws IOException {
        reader.close();
    }

}
