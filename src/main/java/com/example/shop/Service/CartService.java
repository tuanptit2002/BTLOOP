package com.example.shop.Service;

import com.example.shop.Entity.Cart;

import com.example.shop.Entity.NewPair;
import com.example.shop.Entity.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {
    public ResponseEntity<?> create(Cart cart);
    public ResponseEntity<?> addItemWithCart(Cart cart);



    public ResponseEntity<?> buyAllItem(Long id);

    public Cart getById(Long idCart);

    public List<Pair> getAllIdItemInCart(Long id);
}
