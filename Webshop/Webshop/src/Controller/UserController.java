package Controller;


import Model.User;

import java.util.List;
import java.util.Vector;

public abstract class UserController {

    private List<User> userList = new Vector<>();

    private int userID = 0;

    /**
     * Checking if the User is and Employee or a Customer that is saved in the userList
     *
     * @param id This is the id of the User
     * @return returns true when the User is an Employee, otherwise it returns false
     */
    public boolean getUserStatus(int id) {
        for (int i = 0; i < this.userList.size(); i++) {
            if (this.userList.get(i).getIdNum() == id) {
                if (this.userList.get(i).isEmployee()) {
                    return true;
                }
            }
        }

        return false;
    }

    public List<User> getUserList() {
        return this.userList;
    }

    public int generateUserID() {
        if(userList.size() == 0) {
            this.userID++;
        }else{
            this.userID = userList.size() + 1;
        }
        return this.userID;
    }

    public int getUserID(User user){
        return user.getIdNum();
    }

    public void addUser(User user) {
        userList.add(user);

    }

}
