package com.test.sandbox;

public class HanaMessage {
    private String text;
    private boolean belongsToCurrentUser;

    public HanaMessage(String text, boolean belongsToCurrentUser) {
        this.text = text;
        this.belongsToCurrentUser = belongsToCurrentUser;
    }

    public String getText() {
        return text;
    }

    public boolean isBelongsToCurrentUser() {
        return belongsToCurrentUser;
    }
}
