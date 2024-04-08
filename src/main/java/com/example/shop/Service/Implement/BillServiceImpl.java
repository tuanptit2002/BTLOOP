package com.example.shop.Service.Implement;

import com.example.shop.Entity.Bill;
import com.example.shop.Repository.BillRepository;
import com.example.shop.Service.BillService;
import com.example.shop.Service.CartItemService;
import com.example.shop.Service.CartService;
import com.example.shop.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {


    @Autowired
    BillRepository billRepository;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    CartService  cartService;

    @Autowired
    ItemService itemService;

    @Override
    public ResponseEntity<?> create(Bill bill){
        billRepository.save(bill);

        cartService.getAllIdItemInCart(bill.getCart().getId());
        cartItemService.updateStatus(bill.getCart().getId());
        return new ResponseEntity<>("create Bill success", HttpStatus.CREATED);
    }
}
