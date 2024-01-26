package com.example.shop.Service;

import com.example.shop.Entity.Item;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {
    public ResponseEntity<?> create(Item item);

    public Item getById(Long idItem);
}
