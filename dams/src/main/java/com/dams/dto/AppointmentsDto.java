package com.dams.dto;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AppointmentsDto {

	private Long appointmentId;
	private Long doctor;
	private Long patient;
	private Date appointmentDate;
	private Time appointmentTime;
	private String status;
	private Timestamp createdAt;
	//private Payments payment;

}
