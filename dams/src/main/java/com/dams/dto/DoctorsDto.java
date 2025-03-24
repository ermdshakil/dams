package com.dams.dto;

import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorsDto {
    private Long doctorId;
    private Long userId; // Links to Users table (only for users with Role.DOCTOR)
    private String specialization;
    private int experience;
    private Long licenseNumber;
    private String availableDays;
    private LocalTime availableTime;
		/*
		 * private List<Appointments> appointments; private List<Reviews> Reviews;
		 */

}
