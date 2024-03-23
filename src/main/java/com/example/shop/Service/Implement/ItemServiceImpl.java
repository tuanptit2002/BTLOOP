package com.example.shop.Service.Implement;

import com.example.shop.Entity.Item;
import com.example.shop.Repository.ItemRepository;
import com.example.shop.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Autowired
    CartItemService  cartItemService;

    @Override
    public ResponseEntity<?> create(Item item){
        itemRepository.save(item);
        return new ResponseEntity<>("Create Item success", HttpStatus.CREATED);
    }

    @Override
    public Item getById(Long idItem){
        return itemRepository.getItemById(idItem);
    }
    @Override
    public List<Item> getAllItemInCart(Long id) {
        List<Long> idItems  = cartItemService.getFullIdItem(id);
        List<Item> items = new ArrayList<>();
        for (Long idItem : idItems){
            Item item = getById(idItem);
            items.add(item);
        }
        return items;
    }
    public List<Item> getAllItemWithCategory(Long idCategory){
        return itemRepository.getAllItemWithCategoryId(idCategory);
    }
    @Override
    public List<Item> getAll(){
        return itemRepository.getAllItem();
    }
// todo: fix đoạn này chưa được cập nhật count cho từng item;
//    public boolean updateItem(List<Item> items) {
//        for (Item item : items) {
//            Optional<Item> itemRepo = itemRepository.findById(item.getId());
//            if (item.getCount() <= itemRepo.get().getCount() && itemRepo.get().getCount() > 0) {
//                long count = itemRepo.get().getCount() - item.getCount();
//                itemRepo.orElseThrow().setCount(count);
//                return true;
//            }
//            return false;
//        }
//    }
}
