package com.example.shop.Service.Implement;

import com.example.shop.Entity.City;
import com.example.shop.Repository.CityRepository;
import com.example.shop.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    public ResponseEntity<?> createCity(City city) {
        cityRepository.save(city);
        return new ResponseEntity<>("City created successfully", HttpStatus.CREATED);
    }

    @Override
    public List<City> getAllCity() {
        return cityRepository.getAllCity();
    }

    @Override
    public City getById(Long id) {
        return cityRepository.findCityId(id);
    }
}
