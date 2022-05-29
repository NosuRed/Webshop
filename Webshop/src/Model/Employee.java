package Model;

public class Employee extends User {

    public Employee(String name, String lastName, int id, String userName, String password) {
        super(name, lastName, id, userName, password, true);
    }


    @Override
    public String getHouseNr() {
        return null;
    }

    @Override
    public String getStreetName() {
        return null;
    }
}
