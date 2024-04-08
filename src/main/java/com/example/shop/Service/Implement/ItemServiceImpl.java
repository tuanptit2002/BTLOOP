package com.example.shop.Service.Implement;

import com.example.shop.Entity.Item;
import com.example.shop.Entity.NewPair;
import com.example.shop.Entity.Pair;
import com.example.shop.Entity.SizeItem;
import com.example.shop.Repository.ItemRepository;
import com.example.shop.Repository.SizeItemRepository;
import com.example.shop.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    SizeItemRepository  sizeItemRepository;

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
    public boolean updateCount(List<Pair> idItems){
        for(Pair item : idItems){
            Long countItem= itemRepository.getCount(item.getId());
            if(countItem < item.getCount()){
                throw new RuntimeException("Khong hop ne");
            }else{
                Item item1 = itemRepository.getItemById(item.getId());
                Long countNew = countItem-item.getCount();
//                SizeItem item1 =  new SizeItem();
                item1.setCount(countNew);
                itemRepository.save(item1);
            }
        }
        return true;
    }
}
