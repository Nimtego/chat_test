package com.tassta.test.chat.model;

import javafx.scene.image.Image;


public class UserImpl implements User {
    private String name;
    private int id;
    private Image iconImage;
    private boolean isOnline = false;

    public UserImpl() {
    }

    public UserImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isOnline() {
        return false;
    }

    @Override
    public Image getIcon() {
        return iconImage;
    }

}
