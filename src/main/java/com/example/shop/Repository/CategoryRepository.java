package com.example.shop.Repository;

import com.example.shop.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from  Category as c where c.id = :id")
    Category getCategoryId(@Param("id") Long id);
}
