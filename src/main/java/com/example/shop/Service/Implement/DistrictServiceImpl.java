package com.example.shop.Service.Implement;

import com.example.shop.Entity.District;
import com.example.shop.Repository.DistrictRepository;
import com.example.shop.Service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public ResponseEntity<?> createDistrict(District district) {
        districtRepository.save(district);
        return new ResponseEntity<>("District created successfully", HttpStatus.CREATED);
    }

    @Override
    public List<District> getAllDistrict() {
        return districtRepository.getAllDistrict();
    }
    public District getById(Long id){
        return districtRepository.findDistrictById(id);
    }
}
