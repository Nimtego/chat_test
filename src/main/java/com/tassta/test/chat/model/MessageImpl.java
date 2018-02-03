package com.tassta.test.chat.model;

import java.util.Date;

/**
 * Created by nimtego_loc on 02.02.2018.
 */
public class MessageImpl implements Message {
    private Date date;
    private String text;
    private User sender;
    private User receiver;

    private MessageImpl(){}

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public User getSender() {
        return sender;
    }

    @Override
    public User getReceiver() {
        return receiver;
    }

    public static MessageBuilder message() {

        return new MessageImpl().new MessageBuilder();
    }
    //Builder iner
    public class MessageBuilder {

        private MessageBuilder() {
        }

        public MessageBuilder date(final Date date) {
            MessageImpl.this.date = date;
            return this;
        }

        public MessageBuilder text(final String text) {
            MessageImpl.this.text = text;
            return this;
        }

        public MessageBuilder sender(final User sender) {
            MessageImpl.this.sender = sender;
            return this;
        }

        public MessageBuilder receiver(final User receiver) {
            MessageImpl.this.receiver = receiver;
            return this;
        }
        public MessageImpl build() {
            MessageImpl message = new MessageImpl();
            message.date = MessageImpl.this.date;
            message.text = MessageImpl.this.text;
            message.sender = MessageImpl.this.sender;
            message.receiver = MessageImpl.this.receiver;
            return message;

        }

    }
}
