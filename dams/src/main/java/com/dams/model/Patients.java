package com.dams.model;

import java.util.Date;
import java.util.List;

import com.dams.enumformodel.Gender;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Patients {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "patient_id")
	private Long patientId;
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, unique = true)
	private Users user;
	@Column(name= "dob")
	private Date dob;
	@Column(name="patient_gender")
	private Gender gender;
	@Column(name="medical_history")
	private String medicalHistory;
	
	@OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
	private Appointments appointment;
	
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reviews> Reviews;
	

}
