package com.dams.servicesImpl;

import java.util.List;

import com.dams.dto.PatientsDto;
import com.dams.enumformodel.Gender;
import com.dams.services.PatientService;

public class PatientServiceImp implements PatientService{

	@Override
	public PatientsDto createPatient(PatientsDto patientsDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientsDto updatePatient(PatientsDto patientsDto, Long patientsId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deletePatientById(Long patientsId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PatientsDto> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientsDto> getAllPatientsByGender(Gender gender) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientsDto getPatientsByAppointmentId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
