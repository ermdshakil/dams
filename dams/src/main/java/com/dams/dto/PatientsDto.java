package com.dams.dto;

import java.util.Date;

import com.dams.enumformodel.Gender;
import com.dams.model.Users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@NoArgsConstructor
@AllArgsConstructor
@Data
public class PatientsDto {
	
	private Long patientId;
	private Users user;
	private Date dob;
	private Gender gender;
	private String medicalHistory;
	//private Appointments appointment;
    //private List<Reviews> Reviews;
	
	

}
