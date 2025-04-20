package com.dams.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dams.enumformodel.Gender;
import com.dams.enumformodel.Role;
import com.dams.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Optional<Users> findByEmail(String email);

    Optional<Users> findByPhone(String phoneNo);

    // Find all users by specific role
    List<Users> findByUserRole(Role role);

    // Find all users by gender
    @Query("SELECT u FROM Users u WHERE u.gender = :gender")
    List<Users> findAllByGender(Gender gender);

    // Find users by gender and role
    @Query("SELECT u FROM Users u WHERE u.gender = :gender AND u.userRole = :role")
    List<Users> findAllByGenderAndRole(
    		@Param("gender") Gender gender, 
    		@Param("role") Role role);
 // Count users by gender and role
    @Query("SELECT COUNT(u) FROM Users u WHERE u.gender = :gender AND u.userRole = :role")
    Long countByGenderAndRole(@Param("gender") Gender gender, @Param("role") Role role);

    // Find all users by specific role using custom query (parameterized)
    @Query("SELECT u FROM Users u WHERE u.userRole = :role")
    List<Users> findAllByRole(@Param("role") Role role);

    // Count users by specific role
    @Query("SELECT COUNT(u) FROM Users u WHERE u.userRole = :role")
    Long countByRole(@Param("role") Role role);

}
