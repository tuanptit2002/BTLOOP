package com.example.shop.Service;

import com.example.shop.Entity.Item;
import com.example.shop.Entity.NewPair;
import com.example.shop.Entity.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    public ResponseEntity<?> create(Item item);

    public Item getById(Long idItem);
    public List<Item> getAllItemInCart(Long idCart);

    public List<Item> getAllItemWithCategory(Long idCategory);
    public List<Item> getAll();

//    public boolean updateItem(List<Item> items);

    public boolean updateCount(List<Pair> idItems);
}
