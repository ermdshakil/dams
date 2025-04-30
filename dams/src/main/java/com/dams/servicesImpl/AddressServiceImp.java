package com.dams.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
	public boolean deleteAddress(Long addressId) {
		Address address = this.addressRepo.findById(addressId).orElseThrow(() ->
		new ResourceNotFoundException("address", "ID", addressId));
				this.addressRepo.delete(address);
		return true;
	}

	@Override
	public AddressDto getAddressById(Long addressId) {
		Address address= this.addressRepo.findById(addressId).orElseThrow(()->
		new  ResourceNotFoundException("address", "ID", addressId));
		return this.modalMapper.map(address, AddressDto.class);
	}

	@Override
	public List<AddressDto> getAllAddresses() {
		List<Address> addresses = this.addressRepo.findAll();
		return addresses.stream().map(address -> 
		this.modalMapper.map(address, AddressDto.class)).collect(Collectors.toList());
		//return (List<AddressDto>) this.modalMapper.map(allAddress, AddressDto.class);
	}

	@Override
	public Long countAddresses() {
		return this.addressRepo.count();
	}

	@Override
	public List<AddressDto> getAllAddressByUserId(Long UserId) {
		@SuppressWarnings("unchecked")
		List<Address> addresses = (List<Address>) this.addressRepo.findAddressByUserId(UserId)
				.orElseThrow(()-> new ResourceNotFoundException("Address", "ID", UserId));
		return addresses.stream().map(address ->
		this.modalMapper.map(addresses, AddressDto.class)).collect(Collectors.toList());
	}
	@Override
	public List<AddressDto> getAllAddressByPatientId(Long patientId) {
		@SuppressWarnings("unchecked")
		List<Address> addresses = (List<Address>) this.addressRepo.findAddressByPatientId(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Address", "ID", patientId));
		return addresses.stream().map(address ->
		this.modalMapper.map(addresses, AddressDto.class)).collect(Collectors.toList());
	}
	@Override
	public Long countAddressesByUserId(Long userId) {
		@SuppressWarnings("unchecked")
		List<Address> addresses = (List<Address>) this.addressRepo.findAddressByUserId(userId)
				.orElseThrow(()-> new ResourceNotFoundException("Address", "ID", userId));
		return (long) addresses.size();
	}
	@Override
	public Long countAddressesByPatientId(Long patientId) {
		@SuppressWarnings("unchecked")
		List<Address> addresses = (List<Address>) this.addressRepo.findAddressByPatientId(patientId)
				.orElseThrow(()-> new ResourceNotFoundException("Address", "ID", patientId));
		return (long) addresses.size();
	}

}
