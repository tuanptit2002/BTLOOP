package com.example.shop.DTO;

import lombok.Data;

@Data
public class AuthenticationResponse {

    public String access_token;
    private String user_name;
    private String email;
}
