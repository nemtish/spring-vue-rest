package com.cyrillic.farm.resource;

public class AuthToken {

    private final String prefix = "Bearer ";
    private String token;

    public AuthToken() {
        super();
    }
    public AuthToken(String token) {
        this.token = prefix.concat(token);
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = prefix.concat(token);
    }
    
    
}
