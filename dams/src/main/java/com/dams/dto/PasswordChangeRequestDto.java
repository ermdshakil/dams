package com.dams.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class PasswordChangeRequestDto{
	
	private Long userId;
	private String password;
	
}