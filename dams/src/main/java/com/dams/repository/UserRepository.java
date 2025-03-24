package com.dams.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dams.model.Users;


public interface UserRepository extends JpaRepository<Users, Long>{

	Optional<Users> findByEmail(String email);
	Optional<Users> findByPhone(String phoneNo);

}


