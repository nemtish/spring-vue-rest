package com.cyrillic.farm.resource;

public class AuthUser {
    
    private String username;
    private String token;

    public AuthUser() {
    }

    public AuthUser(String username, String token) {
        this.username = username;
        this.token = token;
    }
    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }
}
