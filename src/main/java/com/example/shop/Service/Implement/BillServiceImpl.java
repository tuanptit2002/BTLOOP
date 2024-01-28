package com.example.shop.Service.Implement;

import com.example.shop.Entity.Bill;
import com.example.shop.Repository.BillRepository;
import com.example.shop.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BillServiceImpl implements BillService {


    @Autowired
    BillRepository billRepository;


    @Override
    public ResponseEntity<?> create(Bill bill){
        billRepository.save(bill);
        return new ResponseEntity<>("create Bill success", HttpStatus.CREATED);
    }
}
