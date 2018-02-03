package com.tassta.test.chat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nimtego_loc on 03.02.2018.
 */
public class UserListModelImpl implements UserListModel {
    private Map<Integer, User> userMap;
    private Integer id;

    public UserListModelImpl() {
        userMap = new HashMap<>();
        id = 1;
    }
    @Override
    public ObservableList<User> getUserList() {
        return FXCollections.observableArrayList(userMap.values());
    }

    @Override
    public boolean setUser(User user) {
        if (user.getId() == 0) {
            userMap.put(id++, user);
            return true;
        }
        for (int id: userMap.keySet()) {
           if (id == user.getId()) {
               return false;
           }
        }
        userMap.put(user.getId(), user);
        return true;
    }
}
