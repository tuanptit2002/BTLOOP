package com.example.shop.Service.Implement;

import com.example.shop.Entity.Item;
import com.example.shop.Repository.ItemRepository;
import com.example.shop.Service.CategoryService;
import com.example.shop.Service.DescriptionItemService;
import com.example.shop.Service.DiscountService;
import com.example.shop.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    CategoryService categoryService;
    @Autowired
    DiscountService discountService;
    @Autowired
    DescriptionItemService descriptionItemService;

    @Override
    public ResponseEntity<?> create(Item item){
        itemRepository.save(item);
        return new ResponseEntity<>("Create Item success", HttpStatus.CREATED);
    }

    @Override
    public Item getById(Long idItem){
        return itemRepository.getItemById(idItem);
    }
}
