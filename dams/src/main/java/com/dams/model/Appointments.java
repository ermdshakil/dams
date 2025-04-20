package com.dams.model;

import com.dams.enumformodel.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "appointments")
public class Appointments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointment_id")
    private Long appointmentId;

    @FutureOrPresent(message = "Appointment date must be in the present or future")
    @Column(name = "appointment_date", nullable = false)
    private LocalDate appointmentDate;

    @FutureOrPresent(message = "Appointment time must be in the present or future")
    @Column(name = "appointment_time", nullable = false)
    private LocalTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctors doctor;

    @OneToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patients patient;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payments payment;

    // Convenience methods for checking appointment status
    public boolean isCompleted() {
        return this.status == Status.COMPLETED;
    }

    public boolean isScheduled() {
        return this.status == Status.SCHEDULED;
    }

    public boolean isReScheduled() {
        return this.status == Status.RESCHEDULED;
    }

    public boolean isCanceled() {
        return this.status == Status.CANCELED;
    }
}
