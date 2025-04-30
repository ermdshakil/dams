package com.dams.servicesImpl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dams.dto.DoctorDto;
import com.dams.dto.UsersDto;
import com.dams.enumformodel.Gender;
import com.dams.enumformodel.Role;
import com.dams.exception.ResourceNotFoundException;
import com.dams.model.Doctors;
import com.dams.model.Users;
import com.dams.repository.DoctorsRepo;
import com.dams.repository.UserRepository;
import com.dams.services.DoctorService;

public class DoctorServiceImp implements DoctorService {

	@Autowired
	public ModelMapper modelMapper;

	@Autowired
	public DoctorsRepo doctorRepo;
	@Autowired
	public UserRepository userRepo;

	@Override
	public DoctorDto createDoctor(DoctorDto doctorDto) {
		Doctors doctor = this.modelMapper.map(doctorDto, Doctors.class);
		return this.modelMapper.map(this.doctorRepo.save(doctor), DoctorDto.class);
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId) {
		Doctors doctor = this.doctorRepo.findById(doctorId)
				.orElseThrow(() -> new ResourceNotFoundException("doctor", "ID", doctorId));
		// Update basic fields
		doctor.setSpecialization(doctorDto.getSpecialization());
		doctor.setExperience(doctorDto.getExperience());
		doctor.setLicenseNumber(doctorDto.getLicenseNumber());
		// Update availableDays from DTO
		if (doctorDto.getAvailableDays() != null) {
			Set<DayOfWeek> updatedDays = doctorDto.getAvailableDays().stream()
					.map(day -> DayOfWeek.valueOf(day.toUpperCase())).collect(Collectors.toSet());
			doctor.setAvailableDays(updatedDays);
		}
		// Update availableFrom
		if (doctorDto.getAvailableFrom() != null) {
			doctor.setAvailableFrom(LocalDateTime.parse(doctorDto.getAvailableFrom()));
		}
		// Update availableTo
		if (doctorDto.getAvailableTo() != null) {
			doctor.setAvailableTo(LocalDateTime.parse(doctorDto.getAvailableTo()));
		}
		return this.modelMapper.map(this.doctorRepo.save(doctor), DoctorDto.class);
	}

	@Override
	public boolean deleteDoctorById(Long doctorId) {
		Doctors doctor =this.doctorRepo.findById(doctorId)
				.orElseThrow(()-> new ResourceNotFoundException("doctor", "ID", doctorId));
		this.doctorRepo.delete(doctor);
		return true;
	}

	@Override
	public boolean deleteDoctorByUserId(Long userId) {
		Doctors doctor =this.doctorRepo.findByUserId(userId)
				.orElseThrow(()-> new ResourceNotFoundException("doctor not found by user id", "Id", userId));
		this.doctorRepo.delete(doctor);
		return true;
	}

	@Override
	public List<UsersDto> getAllFemaleDoctor() {
		List<Users> fDoctors = this.userRepo.findAllByGenderAndRole(Gender.FEMALE, Role.DOCTOR);
		return fDoctors.stream()
                .map(user -> modelMapper.map(user, UsersDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public List<UsersDto> getAllMaleDoctor() {
		List<Users> mDoctors =this.userRepo.findAllByGenderAndRole(Gender.MALE, Role.DOCTOR);
		return mDoctors.stream()
				.map(doctor -> modelMapper.map(mDoctors, UsersDto.class))
				.collect(Collectors.toList());
		
	}

	@Override
	public List<UsersDto> getAllDoctor() {
		List<Users> doctors =this.userRepo.findAllByRole(Role.DOCTOR);
		return doctors.stream()
				.map(doctor -> modelMapper.map(doctors, UsersDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<DoctorDto> getAllDoctorBySpecialization(String specialization) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorDto> getAllDoctorByDays(String day) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countDoctor() {
		return this.doctorRepo.count();
	}
}
