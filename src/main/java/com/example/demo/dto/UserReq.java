package com.example.demo.dto;

import lombok.Data;

@Data
public class UserReq {
    private String username, email, password, rPassword;

    public boolean passwordMatches() {
        return password != null && password.equals(rPassword);
    }
}
