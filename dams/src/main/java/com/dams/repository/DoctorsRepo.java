package com.dams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dams.model.Doctors;

public interface DoctorsRepo extends JpaRepository<Doctors, Long>{

}
