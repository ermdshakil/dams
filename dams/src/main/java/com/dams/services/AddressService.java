package com.dams.services;

import java.util.List;

import com.dams.dto.AddressDto;

public interface AddressService {

    AddressDto createAddress(AddressDto addressDto);
    AddressDto updateAddress(AddressDto addressDto, Long addressId);
    int deleteAddress(Long addressId);
    AddressDto getAddressById(Long addressId);
    List<AddressDto> getAllAddressByUserId(Long UserId);
    List<AddressDto> getAllAddresses();
    Long countAddresses();
}
