package com.example.shop.Service;

import com.example.shop.Entity.Address;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    public ResponseEntity<?> createAddress(Address address);

}
