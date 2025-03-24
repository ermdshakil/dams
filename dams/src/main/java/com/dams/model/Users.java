package com.dams.model;

import java.time.LocalDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.dams.enumformodel.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "first_name", nullable = false)
    private String fName;

    @Column(name = "last_name", nullable = false)
    private String lName;

    @Column(name = "email_id", unique = true, nullable = false)
    private String email;

    @Column(name = "phone_no", unique = true, nullable = false)
    private String phone;

    @Column(name = "password", nullable = false)
    private String password; // Ensure hashed storage in the service layer

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private Role userRole;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // One-to-Many relation with Address
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> userAddress;

    // One-to-One relation with Doctors (only for Doctors)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Doctors doctor;

    // Method to check if the user is a doctor
    public boolean isDoctor() {
        return this.userRole == Role.DOCTOR;
    }
    // One-to-One relation with Doctors (only for Doctors)
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Patients pacient;

    // Method to check if the user is a Patient
    public boolean isPatient() {
        return this.userRole == Role.PATIENT;
    }
    public boolean isAdmin() {
        return this.userRole == Role.ADMIN;
    }
}
