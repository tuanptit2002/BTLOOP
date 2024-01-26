package com.example.shop.Repository;

import com.example.shop.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findCartById(Long id);
    // bug cho nay  nhe
//    @Query("select c from Cart  as c inner join Cart_Item as where c.id = :id and c.status ='FALSE'")
//    Cart getAllItemInCart(@Param("id") Long id);
}
