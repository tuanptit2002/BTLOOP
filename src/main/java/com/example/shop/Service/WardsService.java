package com.example.shop.Service;

import com.example.shop.Entity.City;
import com.example.shop.Entity.Wards;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WardsService {

    public ResponseEntity<?> createWards(Wards wards);
    public List<Wards> getAllWards();
    public Wards getById(Long id);
}
