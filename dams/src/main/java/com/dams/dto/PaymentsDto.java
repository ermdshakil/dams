package com.dams.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentsDto {

	private Long paymentId;
	private Long appointment;
	private double payAmount;
	private String status;
	private Timestamp payment_date;
}
