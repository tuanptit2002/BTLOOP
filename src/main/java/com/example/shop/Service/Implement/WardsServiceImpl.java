package com.example.shop.Service.Implement;

import com.example.shop.Entity.Wards;
import com.example.shop.Repository.WardsRepository;
import com.example.shop.Service.WardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WardsServiceImpl implements WardsService {
    @Autowired
    WardsRepository wardsRepository;
    @Override
    public ResponseEntity<?> createWards(Wards wards){
        wardsRepository.save(wards);
        return new ResponseEntity<>("Wards created successfully", HttpStatus.CREATED);
    }
    @Override
    public List<Wards> getAllWards(){
        return wardsRepository.getAllWards();
    }

    @Override
    public Wards getById(Long id){
        return wardsRepository.findWardsById(id);
    }
}
