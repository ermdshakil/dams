package com.dams.services;

import java.util.List;

import com.dams.dto.DoctorDto;

public interface DoctorService {
	
    DoctorDto createDoctor(DoctorDto doctorDto);
    DoctorDto updateDoctor(DoctorDto doctorDto, Long doctorId);
    int deleteDoctorById(Long doctorId);
    int deleteDoctorByUserId(Long userId);
    List<DoctorDto> getAllFemaleDoctor();
    List<DoctorDto> getAllMaleDoctor();
    List<DoctorDto> getAllDoctor();
    List<DoctorDto> getAllDoctorBySpecialization(String specialization);
    List<DoctorDto> getAllDoctorByDays(String day);
    Long countDoctor();

}
