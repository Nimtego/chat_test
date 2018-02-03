package com.tassta.test.chat.model;

import javafx.collections.ObservableList;

/**
 * Created by nimtego_loc on 03.02.2018.
 */
public class UserController {

    private UserListModel userListModel;
    private User currentUser;

    public boolean setUser(String name) {
        if (userListModel == null) {
            userListModel = new UserListModelImpl();
        }
        ObservableList<User> tmpCheck = userListModel.getUserList();
        for (User us: tmpCheck) {
            if (us.getName().equals(name)) {
                return false;
            }
        }
        User user = new UserImpl(name);
        userListModel.setUser(user);
        for (User us : userListModel.getUserList()) {
            if (us.getName().equals(name)) {
                currentUser = us;
            }
        }
        return true;
    }
    public User getCurrentUser() {
        return currentUser;
    }
    public void clear() {
        currentUser = null;
    }
}
