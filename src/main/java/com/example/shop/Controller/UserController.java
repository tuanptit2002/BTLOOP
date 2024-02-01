package com.example.shop.Controller;

import com.example.shop.Config.JwtTokenUtil;
import com.example.shop.DTO.AuthenticationRequest;
import com.example.shop.DTO.AuthenticationResponse;
import com.example.shop.DTO.UserDTO;
import com.example.shop.Entity.User;
import com.example.shop.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        userService.createUser(mapper(userDTO));
        return new ResponseEntity<>("create user success", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest user) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        Authentication authentication = authenticationManager.authenticate(token);
        User userNew = (User) authentication.getPrincipal();
        String jwt = jwtTokenUtil.generateToken(userNew);
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setAccess_token(jwt);
        authenticationResponse.setFullName(userNew.getName());
        authenticationResponse.setEmail(userNew.getEmail());
        return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
    }

    private User mapper(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getFullName());
        user.setPhone(userDTO.getPhone());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return user;
    }
}
