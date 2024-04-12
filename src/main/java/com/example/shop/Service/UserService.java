package com.example.shop.Service;

import com.example.shop.Entity.Item;
import com.example.shop.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    public void createUser(User user);

    public List<Item> getAllItem(User  user);
}
