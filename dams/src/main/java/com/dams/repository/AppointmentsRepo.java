package com.dams.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dams.model.Appointments;

public interface AppointmentsRepo extends JpaRepository<Appointments, Long>{
	
	@Query("SELECT a FROM Appointments a WHERE a.appointmentId = :appointmentId")
    Optional<Appointments> findByAppointmentId(@Param("appointmentId") Long appointmentId);

	@Query("SELECT a FROM Appointments a WHERE a.doctor = :doctor")
    List<Appointments> findByDoctor(@Param("doctor") Long doctorId);
	
    @Query("SELECT a FROM Appointments a WHERE a.patient = :patient")
    Optional<Appointments> findByPatient(Long patient);
    
    @Query("SELECT a FROM Appointments a WHERE a.appointmentDate = :appointmentDate")
    List<Appointments> findByAppointmentDate(@Param("appointmentDate") Date appointmentDate);
    
    
}
