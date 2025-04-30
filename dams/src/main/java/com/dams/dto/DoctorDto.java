package com.dams.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDto {

    private Long doctorId;
    private String specialization;
    private Integer experience;
    private String licenseNumber;
    private Set<String> availableDays; // We will use String for display purposes (e.g., "MONDAY", "TUESDAY")
    private String availableFrom;
    private String availableTo;
    private String fullName;
}
