package com.solbeg.testtask.citiesshower.util;

public enum  UsersEnum {
    USER("ROLE_ALLOW_EDIT");

    private String user;

    UsersEnum(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }
}
