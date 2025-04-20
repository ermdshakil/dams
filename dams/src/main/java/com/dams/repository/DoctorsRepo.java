package com.dams.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dams.model.Doctors;

public interface DoctorsRepo extends JpaRepository<Doctors, Long>{
	
	@Query("SELECT a FROM Doctors a WHERE a.doctorId = :doctorId")
    List<Doctors> findByDoctorId(@Param("doctorId") Long doctorId);
	
    @Query("SELECT a FROM Doctors a WHERE a.user = :user")
    Optional<Doctors> findByUserId(Long user);
  

}
