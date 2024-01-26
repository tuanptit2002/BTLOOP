package com.example.shop.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    @JoinTable(name = "cartItem", joinColumns = @JoinColumn(name = "cart_id"), inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

}
