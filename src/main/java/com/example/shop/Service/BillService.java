package com.example.shop.Service;

import com.example.shop.Entity.Bill;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public interface BillService {
    public ResponseEntity<?> create(Bill bill);
}
