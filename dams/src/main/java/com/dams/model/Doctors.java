package com.dams.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctors")
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, unique = true)
    private Users user; // Links to Users table (only for users with Role.DOCTOR)

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "experience")
    private int experience;
    
    private Long license_number;

    @Column(name = "available_days")
    private String availableDays;

    @Column(name = "available_time")
    private LocalTime availableTime;
    
    // One-to-Many relation with appointments
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointments> appointments;
    
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reviews> Reviews;

}
