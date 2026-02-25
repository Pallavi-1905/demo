package com.example.demo;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins= "*")

public class UserController {
    private UserRepository userRepo;
    
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }
  
  @GetMapping("/demo")
  String demo()
  {
    return "Trust Issues";

  }
  @GetMapping("/users")
  public List<Users> getAllUsers()
  {
    return this.userRepo.findAll();
  }
  @PostMapping("/register")
  public ResponseEntity<String> register(@RequestBody Users user)
  {
    Users u=this.userRepo.findByEmail(user.getEmail());
    if(u!=null){
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Email Already Exists");
    }
    this.userRepo.save(user);
    return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
  }

}