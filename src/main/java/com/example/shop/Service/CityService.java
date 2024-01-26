package com.example.shop.Service;

import com.example.shop.Entity.City;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CityService {
    public ResponseEntity<?> createCity(City city);
    public List<City> getAllCity();
    public City getById(Long id);
}
