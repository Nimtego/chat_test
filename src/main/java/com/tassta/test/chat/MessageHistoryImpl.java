package com.tassta.test.chat;

import com.tassta.test.chat.model.Message;
import javafx.collections.ObservableList;

/**
 * Created by nimtego_loc on 03.02.2018.
 */
public class MessageHistoryImpl implements MessageHistory{
    private ObservableList<Message> listOfMessage;
    @Override
    public ObservableList<Message> getMessageList() {
        return listOfMessage;
    }
}
