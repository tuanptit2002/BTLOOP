package com.example.shop.Controller;

import com.example.shop.Common.MapAddress;
import com.example.shop.DTO.AddressDTO;
import com.example.shop.Entity.Address;
import com.example.shop.Entity.City;
import com.example.shop.Entity.District;
import com.example.shop.Entity.Wards;
import com.example.shop.Service.AddressService;
import com.example.shop.Service.CityService;
import com.example.shop.Service.DistrictService;
import com.example.shop.Service.WardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @Autowired
    CityService cityService;

    @Autowired
    WardsService wardsService;

    @Autowired
    DistrictService districtService;

    @PostMapping("/create")
    public ResponseEntity<?> createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(mapAddress(addressDTO));
    }
    private Address mapAddress(AddressDTO addressDTO){
        Address address = new Address();
        Wards wards = wardsService.getById(addressDTO.getWardsDTO().getId());
        District district = districtService.getById(addressDTO.getDistrictDTO().getId());
        address.setId(addressDTO.getId());
        address.setDescription(addressDTO.getDescription());
        City city = cityService.getById(addressDTO.getCityDTO().getId());
       address.setDistrict(district);
       address.setWards(wards);
        address.setCity(city);
        return address;
    }
}
