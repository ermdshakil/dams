package com.dams.servicesImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dams.dto.AddressDto;
import com.dams.exception.ResourceNotFoundException;
import com.dams.model.Address;
import com.dams.repository.AddressRepo;
import com.dams.services.AddressService;

public class AddressServiceImp implements AddressService {
	@Autowired
	private ModelMapper modalMapper;

	@Autowired
	private AddressRepo addressRepo;

	@Override
	public AddressDto createAddress(AddressDto addressDto) {
		Address address = this.modalMapper.map(addressDto, Address.class);
		return this.modalMapper.map(this.addressRepo.save(address), AddressDto.class);
	}

	@Override
	public AddressDto updateAddress(AddressDto addressDto, Long addressId) {
		Address address = this.addressRepo.findById(addressId)
				.orElseThrow(() -> new ResourceNotFoundException("Address", "ID", addressId));
		address.setHouseNo(addressDto.getHouseNo());
		address.setArea(addressDto.getArea());
		address.setCity(addressDto.getCity());
		address.setState(addressDto.getState());
		address.setCountry(addressDto.getCountry());
		address.setZipCode(addressDto.getZipCode());
		//address.setUserId(addressDto.getUserId());
		return this.modalMapper.map(this.addressRepo.save(address), AddressDto.class);
	}

	@Override
	public int deleteAddress(Long addressId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AddressDto getAddressById(Long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDto> getAllAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDto> getAllAddressByUserId(Long UserId) {
		// TODO Auto-generated method stub
		return null;
	}

}
