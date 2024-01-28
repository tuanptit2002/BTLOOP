package com.example.shop.DTO;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    private AddressDTO addressDTO;
    private RoleDTO roleDTO;


}
