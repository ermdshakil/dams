package com.dams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dams.model.Reviews;

public interface ReviewsRepo extends JpaRepository<Reviews, Long>{

}
