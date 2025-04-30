package com.dams.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.dams.enumformodel.Gender;
import com.dams.enumformodel.Role;
import com.dams.model.Address;
import com.dams.model.Doctors;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private Long userId;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String password;
    private Gender gender;
    private Role userRole;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Address> userAddress;
    private Doctors doctor;

    public void SetCreatedAt() {
        this.createdAt = LocalDateTime.now();
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void SetUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
    // Utility methods to indicate user role
    public boolean isDoctor() {
        return this.userRole == Role.DOCTOR;
    }

    public boolean isAdmin() {
        return this.userRole == Role.ADMIN;
    }
}
