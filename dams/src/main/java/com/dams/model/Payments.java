package com.dams.model;

import java.sql.Timestamp;

import com.dams.enumformodel.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="payment_id")
	private Long paymentId;
	
	@OneToOne
	@JoinColumn(name="appointment_id",referencedColumnName = "appointment_id", nullable = false, unique = true)
	private Appointments appointment;
	
	@Column(name="total_amount")
	private double payAmount;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;
	
	@Column(name="payment_date")
	private Timestamp payment_date;
	
	
	public boolean isCompleted() {
		return this.status== Status.COMPLETED;
		
	}
	public boolean isFailed() {
		return this.status == status.FAILED;
		
	}
	public boolean isPending() {
		return this.status == status.PENDING;
	}

}
