package com.example.shop.Repository;

import com.example.shop.Entity.Item;
import com.example.shop.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query( value = "select u.* from User  as u where u.email = :email", nativeQuery = true)
    User loadByUserName(@Param("email") String email);

    User findByEmail(String email);


}
