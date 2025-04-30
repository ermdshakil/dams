package com.dams.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dams.dto.AddressDto;
import com.dams.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
	@Query("SELECT a FROM Address a WHERE a.user = :user")
	Optional<Address> findAddressByUserId(Long user);
	@Query("SELECT a FROM Address a WHERE a.patient = :patient")
	Optional<Address> findAddressByPatientId(Long patient);
	@Query("SELECT a FROM Address a WHERE a.city = :city")
    List<Address> findByCity(String city);
    @Query("SELECT a FROM Address a WHERE a.country = :country")
    List<Address> findByCountry(String country);
    @Query("SELECT a FROM Address a WHERE a.zipCode = :zipCode")
    List<Address> findByZipCode(@Param("zipCode") String zipCode);
    @Query("SELECT a FROM Address a WHERE a.addressId = :addressId")
    Optional<Address> findByAddressId(@Param("addressId") Long addressId);
    
}
