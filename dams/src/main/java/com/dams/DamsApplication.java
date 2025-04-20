package com.dams;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DamsApplication implements CommandLineRunner {
    
  //  @Autowired
   // private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(DamsApplication.class, args);
    }
    
    @Bean
    ModelMapper modelMapper() {
		return new ModelMapper();
	}
    
    @Override
    public void run(String... args) {
       //userService.save();
    }
    
    
}
