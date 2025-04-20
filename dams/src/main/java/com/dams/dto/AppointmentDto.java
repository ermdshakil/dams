package com.dams.dto;

import com.dams.enumformodel.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppointmentDto {

    private Long appointmentId;
    private LocalDate appointmentDate;
    private LocalTime appointmentTime;
    private Status status;
    
    // Doctor details
    private Long doctorId; 
    private String doctorName; // Optional: Name of the doctor
    
    // Patient details
    private Long patientId; 
    private String patientName; // Optional: Name of the patient
    
    // Payment information (optional)
    private Long paymentId; 
    private Boolean paymentStatus; // Optional: Whether the payment was completed

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Convenience methods to check appointment status
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
