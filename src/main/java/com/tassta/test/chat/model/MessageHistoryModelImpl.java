package com.tassta.test.chat.model;

import java.util.Map;

/**
 * Created by nimtego_loc on 02.02.2018.
 */
public class MessageHistoryModelImpl implements MessageHistoryModel {
    private Map<User, MessageHistory> userMessageHistory;

    @Override
    public MessageHistory getMessageHistory(User user) {
        for (User us : userMessageHistory.keySet())
            if (us.equals(user))
                return userMessageHistory.get(us);
        return null;
    }
}
