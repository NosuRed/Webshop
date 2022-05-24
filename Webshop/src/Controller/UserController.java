package Controller;


import Model.User;

import java.util.List;
import java.util.Vector;

public abstract class UserController {

    public List<User> userList = new Vector<>();


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

    public void addUser(User user) {
        userList.add(user);

    }

}
