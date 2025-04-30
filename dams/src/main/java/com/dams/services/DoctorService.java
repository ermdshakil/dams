package com.dams.services;

import java.util.List;

import com.dams.dto.DoctorDto;
import com.dams.dto.UsersDto;

public interface DoctorService {
	
    DoctorDto createDoctor(DoctorDto doctorDto);
    DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId);
    boolean deleteDoctorById(Long doctorId);
    boolean deleteDoctorByUserId(Long userId);
    List<UsersDto> getAllFemaleDoctor();
    List<UsersDto> getAllMaleDoctor();
    List<UsersDto> getAllDoctor();
    List<DoctorDto> getAllDoctorBySpecialization(String specialization);
    List<DoctorDto> getAllDoctorByDays(String day);
    Long countDoctor();

}
