package com.dams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dams.model.Payments;

public interface PaymentsRepo extends JpaRepository<Payments, Long>{
	
	
    @Query("SELECT a FROM Payments a WHERE a.paymentId = :paymentId")
    Optional<Payments> findByPaymentId(Long paymentId);
    
    @Query("SELECT a FROM Payments a WHERE a.appointment = :appointment")
    Optional<Payments> findByAppointmentId(@Param("appointment") Long appointmentId);

}
