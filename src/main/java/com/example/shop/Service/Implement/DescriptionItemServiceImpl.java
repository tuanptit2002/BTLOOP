package com.example.shop.Service.Implement;

import com.example.shop.Entity.DescriptionItem;
import com.example.shop.Repository.DescriptionItemRepository;
import com.example.shop.Service.DescriptionItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DescriptionItemServiceImpl implements DescriptionItemService {
    @Autowired
    DescriptionItemRepository descriptionItemRepository;

    @Override
    public DescriptionItem getById(Long id) {
        return descriptionItemRepository.getDescriptionItemId(id);
    }

    @Override
    public ResponseEntity<?> create(DescriptionItem descriptionItem) {
        return new ResponseEntity<>("create descriptionItem success", HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> update(DescriptionItem descriptionItem) {
        DescriptionItem descriptionItem1 = descriptionItemRepository.getDescriptionItemId(descriptionItem.getId());
        descriptionItem1.setDescription(descriptionItem.getDescription());
        descriptionItem1.setMaterial(descriptionItem.getForm());
        descriptionItem1.setForm(descriptionItem.getForm());
        return new ResponseEntity<>("Up date descriptionItem success", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        descriptionItemRepository.deleteById(id);
        return new ResponseEntity<>("Delete descriptionItem success", HttpStatus.OK);
    }
}

