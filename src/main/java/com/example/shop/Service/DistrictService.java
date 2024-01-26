package com.example.shop.Service;

import com.example.shop.Entity.District;
import com.example.shop.Entity.Wards;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DistrictService {
    public ResponseEntity<?> createDistrict(District district);
    public List<District> getAllDistrict();
    public District getById(Long id);
}
