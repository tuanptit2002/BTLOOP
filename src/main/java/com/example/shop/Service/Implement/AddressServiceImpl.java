package com.example.shop.Service.Implement;

import com.example.shop.Entity.Address;
import com.example.shop.Repository.AddressRepository;
import com.example.shop.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Override
    public ResponseEntity<?> createAddress(Address address){
        addressRepository.save(address);
        return new ResponseEntity<>("Address create Success", HttpStatus.CREATED);
    }
}
