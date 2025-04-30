package com.dams.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.dams.enumformodel.Gender;
import com.dams.enumformodel.Role;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
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
    private String password; // Should be encrypted in service layer

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role userRole;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    // Corrected mappedBy to match the field in Address class (assumed "user")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Address> userAddress;

    // Corrected mappedBy to match the field in Doctors class (assumed "user")
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Doctors doctor;

    // Utility methods
    public boolean isDoctor() {
        return this.userRole == Role.DOCTOR;
    }

    public boolean isAdmin() {
        return this.userRole == Role.ADMIN;
    }
}
