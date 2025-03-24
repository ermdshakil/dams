package com.dams;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dams.services.UserService;

@SpringBootApplication
public class DamsApplication implements CommandLineRunner {
    
    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DamsApplication.class, args);
    }

    @Override
    public void run(String... args) {
       //userService.save();
    }
    
    
}
