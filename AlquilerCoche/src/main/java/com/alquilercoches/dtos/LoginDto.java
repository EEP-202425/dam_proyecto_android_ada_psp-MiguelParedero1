package com.alquilercoches.dtos;

public class LoginDto {
    
    private String username;
    private String password;

    public String getUsuario() {
        return username;
    }

    public void setUsuario(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

