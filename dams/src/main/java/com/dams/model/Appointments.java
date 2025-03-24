package com.dams.model;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import com.dams.enumformodel.Role;
import com.dams.enumformodel.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Appointments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="appointment_id")
	private Long appointmentId;
	
	@ManyToOne
	@JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id", nullable = false, unique = true)
	private Doctors doctor;
	
	@OneToOne
	@JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = false, unique = true)
	private Patients patient;
  
	@Column(name="appointment_date")
	private Date appointmentDate;
	
	@Column(name="appointment_time")
	private Time appointmentTime;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@Column(name="created_at")
	private Timestamp createdAt;
	
	
	@OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
	private Payments payment;
	
	public boolean isCompleted() {
		return this.status== Status.COMPLETED;
		
	}
	public boolean isScheduled() {
		return this.status == status.SCHEDULED;
		
	}
	public boolean isCanceled() {
		return this.status == status.CANCELED;
	}
}
