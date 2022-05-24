package Model;

public abstract class User {
    private String name = "";
    private String lastName = "";
    private int idNum = -1;
    private String userName = "";
    private String password = "";
    private boolean isEmployee = false;

    public User(String name, String lastName, int id, String userName, String password, boolean isEmployee) {
        this.name = name;
        this.lastName = lastName;
        this.idNum = id;
        this.userName = userName;
        this.password = password;
        this.isEmployee = isEmployee;
    }


    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public int getIdNum() {
        return idNum;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean isEmployee() {
        return isEmployee;
    }
}



