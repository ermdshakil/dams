package com.dams.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PasswordChangeWithOtpDto {

	private String otp;
    private String newPassword;
}
