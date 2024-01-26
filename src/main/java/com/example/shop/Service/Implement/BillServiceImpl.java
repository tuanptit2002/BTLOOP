package com.example.shop.Service.Implement;

import com.example.shop.Repository.BillRepository;
import com.example.shop.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {


    @Autowired
    BillRepository billRepository;


//    public ResponseEntity<?> acceptBill(Bill bill){
//
//    }
}
