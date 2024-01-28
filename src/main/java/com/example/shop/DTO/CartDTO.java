package com.example.shop.DTO;

import lombok.Data;

import java.util.List;

@Data
public class CartDTO {
    private Long id;
    private UserDTO userDTO;
    private List<ItemDTO> itemDTOS;
}
