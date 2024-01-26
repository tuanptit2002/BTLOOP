package com.example.shop.Service.Implement;

import com.example.shop.Entity.Cart;
import com.example.shop.Entity.Item;
import com.example.shop.Repository.CartRepository;
import com.example.shop.Service.CartItemService;
import com.example.shop.Service.CartService;
import com.example.shop.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    ItemService itemService;

    @Override
    public ResponseEntity<?> create(Cart cart) {
        cartRepository.save(cart);
        return new ResponseEntity<>("Create Cart success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> addItemWithCart(Cart cart) {
        Cart cart1 = cartRepository.findCartById(cart.getId());
        if (cart1 != null) {
            cart1.setItems(cart.getItems());
        } else {
            return new ResponseEntity<>("data error", HttpStatus.NOT_ACCEPTABLE);
        }
        cartRepository.save(cart1);
        cartItemService.updateStatus(cart1.getId());
        return new ResponseEntity<>("add Items success", HttpStatus.OK);
    }

    @Override
    public List<Item> getAllItemInCart(Long id) {
        List<Long> idItems  = cartItemService.getFullIdItem(id);
        List<Item> items = new ArrayList<>();
        for (Long idItem : idItems){
            Item item = itemService.getById(idItem);
            items.add(item);
        }
        return items;
    }

//    @Override
//    public Double total(Long id){
//        Double total = 0D;
//        List<Long> idItems  = cartItemService.getFullIdItem(id);
//        for (Long idItem : idItems){
//            Item item = itemService.getById(idItem);
//            Long count  = cartItemService.getCount(id, item.getId());
//            total += item.getPrice()*count;
//        }
//        return total;
//    }


    @Override
    public ResponseEntity<?> buyAllItem(Long idCart) {
        cartItemService.buyAll(idCart);
        return new ResponseEntity<>("Accept all",HttpStatus.ACCEPTED);
    }
}
