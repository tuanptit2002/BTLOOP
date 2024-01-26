package com.example.shop.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @ManyToOne
    private City city;
    @ManyToOne
    private District district;
    @ManyToOne
    private Wards wards;

}
