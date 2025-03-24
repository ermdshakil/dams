package com.dams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dams.model.Appointments;

public interface AppointmentsRepo extends JpaRepository<Appointments, Long>{

}
