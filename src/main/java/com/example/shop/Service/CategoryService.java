package com.example.shop.Service;

import com.example.shop.Entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    public ResponseEntity<?> create(Category category);

    public Category getById(Long id);

    public ResponseEntity<?> update(Category category);

    public ResponseEntity<?> delete(Long id);

}
