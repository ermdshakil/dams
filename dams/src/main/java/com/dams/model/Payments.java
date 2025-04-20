package com.dams.model;

import java.time.Instant; // Use Instant instead of Timestamp
import com.dams.enumformodel.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payments")
public class Payments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentId;

    @Min(value = 0, message = "Total amount must be greater than or equal to 0")
    @Column(name = "total_amount")
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Column(name = "payment_date")
    private Instant paymentDate; // Replacing Timestamp with Instant for better handling of dates/times

    @OneToOne
    @JoinColumn(name = "appointment_id", nullable = false)
    private Appointments appointment;

    // Helper methods for status checks
    public boolean isCompleted() {
        return Status.COMPLETED == this.status;
    }

    public boolean isFailed() {
        return Status.FAILED == this.status;
    }

    public boolean isPending() {
        return Status.PENDING == this.status;
    }
}
