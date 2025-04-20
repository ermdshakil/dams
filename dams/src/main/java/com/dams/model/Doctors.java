package com.dams.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "doctors")
public class Doctors {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(name = "specialization", nullable = false)
    private String specialization;

    @Column(name = "experience", nullable = false)
    private Integer experience;

    @Column(name = "license_number", unique = true, nullable = false)
    private String licenseNumber;

    // Using List<DayOfWeek> for better structure and validation
    @ElementCollection(targetClass = DayOfWeek.class)
    @CollectionTable(name = "doctor_available_days", joinColumns = @JoinColumn(name = "doctor_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "available_day")
    private Set<DayOfWeek> availableDays; 

    @Column(name = "available_time")
    private LocalTime availableTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private Users user; // Only for users with Role.DOCTOR

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointments> appointments;

    // Helper method to get the full name of the doctor
    public String getFullName() {
        if (user == null) {
            return "No User Assigned";
        }
        return String.format("%s %s", user.getFName(), user.getLName());
    }

    // Helper method to display availability
    public String getAvailabilityInfo() {
        if (availableDays == null || availableDays.isEmpty()) {
            return "No available days set.";
        }
        String days = availableDays.stream()
                                   .map(DayOfWeek::name)
                                   .collect(Collectors.joining(", "));
        return String.format("%s at %s", days, (availableTime != null ? availableTime : "Not set"));
    }
}
