package com.example.shop.Controller;

import com.example.shop.Common.MapCategory;
import com.example.shop.DTO.CategoryDTO;
import com.example.shop.Entity.Category;
import com.example.shop.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/create/category")
    public ResponseEntity<?>create(@RequestBody CategoryDTO categoryDTO){
        return categoryService.create(new MapCategory().mapCategory(categoryDTO));
    }

    @GetMapping("get/by/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id){
        return new ResponseEntity<>(new MapCategory().mapCategoryDTO(categoryService.getById(id)), HttpStatus.ACCEPTED);
    }
    @GetMapping("/get/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<Category> categories = categoryService.getAll();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        for (Category category : categories)
        {
            CategoryDTO categoryDTO = mapperDTO(category);
            categoryDTOS.add(categoryDTO);
        }
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }

    private CategoryDTO mapperDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
