package com.tassta.test.chat.model;

import javafx.collections.ObservableList;

import java.util.Date;

/**
 * Created by nimtego_loc on 03.02.2018.
 */
public class UserController {

    private UserListModel userListModel;
    private User currentUser;
    private MessageHistory messageHistory;

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

    public String createMessage(String text) {
        if (messageHistory == null)
            messageHistory = new MessageHistoryImpl();
        StringBuilder sb = new StringBuilder();
        Message message = MessageImpl.message()
                .date(new Date())
                .sender(currentUser)
                .text(text)
                .receiver(null)
                .build();
        messageHistory.setMessage(message);
        sb.append(message.getDate().toString())
                .append(" ")
                .append(message.getSender().getName());
        if (message.getReceiver() != null) {
            sb.append(" ->").append(message.getReceiver().getName());
        }
        sb.append(" :").append(message.getText());
        return String.valueOf(sb);
    }
}
