package com.example.appnutri.model;

public class LoginResponse {
    private boolean success;
    private int userId;
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public int getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }
}

