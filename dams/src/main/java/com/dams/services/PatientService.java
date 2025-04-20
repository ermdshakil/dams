package com.dams.services;

import java.util.List;

import com.dams.dto.PatientsDto;
import com.dams.enumformodel.Gender;

public interface PatientService {

    PatientsDto createPatient(PatientsDto patientsDto);
    PatientsDto updatePatient(PatientsDto patientsDto, Long patientsId);
    int deletePatientById(Long patientsId);
    List<PatientsDto> getAllPatients();
    List<PatientsDto> getAllPatientsByGender(Gender gender);
    PatientsDto getPatientsByAppointmentId(Long id);
    Long countPatients();
}
