package com.dams.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Table(name = "patients")
public class Patients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long patientId;

    @Past(message = "Date of birth must be in the past")
    @Column(name = "dob", nullable = false)
    private LocalDate dob;
    
    @Column(name="patient_name")  
    private String patientName;
    
    @Column(name="email")  
    private String email;
    
    @Column(name="phone_no")
    private String phoneNo;
    
    @Column(name="password")  
    private String password;
    
    @Transient // not stored in the DB, hardcoded for business logic
    private final String patientRole = "PATIENT";

    @Column(name = "medical_history")
    private String medicalHistory;

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Appointments appointment;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Address> userAddress;

    // Helper method to check if the patient has any appointments
    public boolean hasAppointments() {
        return appointment != null;
    }
}
