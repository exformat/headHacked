package res;

import users.User;

import java.util.ArrayList;

/**
 * Created by Exformat on 13.08.17.
 */
public class UserList {

    private ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }
}
