package com.dams.dto;

import lombok.*;
import java.time.LocalTime;
import java.util.Set;

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
    private LocalTime availableTime;
    private String fullName;
}
