package com.example.shop.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String password;
    @OneToOne
    private Address address;
    @ManyToOne
    private Role role;
}
