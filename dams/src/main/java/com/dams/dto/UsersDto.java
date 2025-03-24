package com.dams.dto;

import java.time.LocalDateTime;

import com.dams.enumformodel.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersDto {
	
	private Long userId;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String phone;
    private Role userRole; // Storing role as a String
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //private List<AddressDto> addresses; // Include addresses for the user
	//private Doctors doctor;
	    
}
