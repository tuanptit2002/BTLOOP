package com.example.shop.Controller;

import com.example.shop.DTO.BillDTO;
import com.example.shop.Entity.Bill;
import com.example.shop.Entity.Cart;
import com.example.shop.Service.BillService;
import com.example.shop.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill")
public class BillController {

    @Autowired
    BillService billService;

    @Autowired
    CartService cartService;
    @PostMapping("/create/bill")
    public ResponseEntity<?> create(@RequestBody BillDTO billDTO){
        return billService.create(mapper(billDTO));
    }

    private Bill mapper(BillDTO billDTO){
        Bill bill = new Bill();
        bill.setId(billDTO.getId());
        bill.setTotalPrice(billDTO.getTotalPrice());
        Cart cart = new Cart();
        cart.setId(billDTO.getCartDTO().getId());
        bill.setCart(cart);
        return bill;
    }
}
