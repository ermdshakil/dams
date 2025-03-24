package com.dams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dams.model.Patients;

public interface PatientsRepo extends JpaRepository<Patients, Long>{

}
