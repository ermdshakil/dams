package com.dams.dto;

import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientsDto {

    private Long patientId;
    private LocalDate dob;
    private String medicalHistory;
    private String patientName;
    private String email;
    private String phoneNo;
    private String password;
    private List<Long> userAddressIds; // Instead of including the whole Address, just the IDs
    private Boolean hasAppointments;
}
