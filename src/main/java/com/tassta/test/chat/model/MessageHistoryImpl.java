package com.tassta.test.chat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by nimtego_loc on 03.02.2018.
 */
public class MessageHistoryImpl implements MessageHistory{
    private ObservableList<Message> listOfMessage;

    public MessageHistoryImpl() {
        listOfMessage = FXCollections.observableArrayList();
    }
    @Override
    public ObservableList<Message> getMessageList() {
        return listOfMessage;
    }

    @Override
    public void setMessage(Message message) {
        listOfMessage.add(message);
    }
}
