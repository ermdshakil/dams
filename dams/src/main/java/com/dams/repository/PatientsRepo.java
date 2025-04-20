package com.dams.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dams.model.Patients;
import com.dams.model.Users;

public interface PatientsRepo extends JpaRepository<Patients, Long> {

	@Query("SELECT a FROM Patients a WHERE a.patientId = :patientId")
	List<Patients> findByPatientsId(@Param("patientId") Long patientId);

	Optional<Patients> findByEmail(String email);

	Optional<Patients> findByPhoneNo(String phoneNo);
}
