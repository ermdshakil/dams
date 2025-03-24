package com.dams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dams.model.Payments;

public interface PaymentsRepo extends JpaRepository<Payments, Long>{

}
