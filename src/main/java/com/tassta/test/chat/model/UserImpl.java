package com.tassta.test.chat.model;

import javafx.scene.image.Image;

/**
 * Date: 31.08.2017.
 * Time: 22:41.
 *
 * @author Pavel Gavrilov.
 */
public class UserImpl implements User {
    private String name;
    private int id;
    private Image iconImage;

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
