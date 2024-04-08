package com.example.shop.Repository;

import com.example.shop.Entity.SizeItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeItemRepository extends JpaRepository<SizeItem, Long> {
}
