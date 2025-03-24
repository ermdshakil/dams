package com.dams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dams.model.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {

	
	 @Query("SELECT a FROM Address a WHERE a.city = :city")
    List<Address> findByCity(String city);
    @Query("SELECT a FROM Address a WHERE a.country = :country")
    List<Address> findByCountry(String country);
    @Query("SELECT a FROM Address a WHERE a.zipcode = :zipcode")
    List<Address> findByZipcode(@Param("zipcode") String zipCode);
}
