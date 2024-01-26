package com.example.shop.Common;

import com.example.shop.DTO.CategoryDTO;
import com.example.shop.Entity.Category;

public class MapCategory {
    public Category mapCategory(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setId(categoryDTO.getId());
        category.setName(categoryDTO.getName());
        return category;
    }
    public CategoryDTO mapCategoryDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
