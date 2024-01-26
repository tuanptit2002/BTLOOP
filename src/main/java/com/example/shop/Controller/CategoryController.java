package com.example.shop.Controller;

import com.example.shop.Common.MapCategory;
import com.example.shop.DTO.CategoryDTO;
import com.example.shop.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    public ResponseEntity<?>create(@RequestBody CategoryDTO categoryDTO){
        return categoryService.create(new MapCategory().mapCategory(categoryDTO));
    }

    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(new MapCategory().mapCategoryDTO(categoryService.getById(id)), HttpStatus.ACCEPTED);
    }
}
