package Model;

public class Customer extends User {
    private String houseNumber = "";
    private String streetName = "";



    public Customer(String name, String lastName, int id, String userName, String password,String houseNumber, String streetName){
        super(name, lastName, id, userName, password, false);
        this.houseNumber = houseNumber;
        this.streetName = streetName;
    }


}
