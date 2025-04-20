package com.dams.dto;

import com.dams.enumformodel.Status;
import lombok.*;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentsDto {

    private Long paymentId;
    private double totalAmount;
    private Status status;
    private Instant paymentDate;
    private Long appointmentId; // Store only the ID of the related appointment for performance reasons
}
