package com.example.shop.Service;

import com.example.shop.Entity.Cart;
import com.example.shop.Entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public ResponseEntity<?> create(Cart cart);
    public ResponseEntity<?> addItemWithCart(Cart cart);

    public List<Item> getAllItemInCart(Long id);

    public ResponseEntity<?> buyAllItem(Long id);


}
