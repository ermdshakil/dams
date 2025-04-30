package com.dams.services;

import java.util.List;

import com.dams.dto.AddressDto;

public interface AddressService {

    AddressDto createAddress(AddressDto addressDto);
    AddressDto updateAddress(AddressDto addressDto, Long addressId);
    boolean deleteAddress(Long addressId);
    AddressDto getAddressById(Long addressId);
    List<AddressDto> getAllAddresses();
    List<AddressDto> getAllAddressByUserId(Long UserId);
    Long countAddresses();
    Long countAddressesByUserId(Long userId);
	List<AddressDto> getAllAddressByPatientId(Long patientId);
	Long countAddressesByPatientId(Long patientId);
}
