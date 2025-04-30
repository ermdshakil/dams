package com.dams.servicesImpl;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.dams.dto.DoctorDto;
import com.dams.exception.ResourceNotFoundException;
import com.dams.model.Doctors;
import com.dams.repository.DoctorsRepo;
import com.dams.services.DoctorService;

public class DoctorServiceImp implements DoctorService{

	@Autowired
	public ModelMapper modelMapper;
	
	@Autowired
	public DoctorsRepo doctorRepo; 
	
	@Override
	public DoctorDto createDoctor(DoctorDto doctorDto) {
		Doctors doctor = this.modelMapper.map(doctorDto, Doctors.class);
		return this.modelMapper.map(this.doctorRepo.save(doctor), DoctorDto.class);
	}

	@Override
	public DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId) {
		Doctors doctor= this.doctorRepo.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("doctor", "ID", doctorId));
		// Update basic fields
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctor.setExperience(doctorDto.getExperience());
        doctor.setLicenseNumber(doctorDto.getLicenseNumber());
        // Update availableDays from DTO
        if (doctorDto.getAvailableDays() != null) {
            Set<DayOfWeek> updatedDays = doctorDto.getAvailableDays().stream()
                    .map(day -> DayOfWeek.valueOf(day.toUpperCase()))
                    .collect(Collectors.toSet());
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
	public int deleteDoctorById(Long doctorId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteDoctorByUserId(Long userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DoctorDto> getAllFemaleDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorDto> getAllMaleDoctor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoctorDto> getAllDoctor() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}
}
