package com.dams.services;

import java.util.List;

import com.dams.dto.AppointmentDto;

public interface AppointmentService {
	
	AppointmentDto createAppiontment(AppointmentDto appintDto);
	AppointmentDto updateAppiontment(AppointmentDto appintDto, Long appointId);
	int deleteAppiontment(Long appointId);
	List<AppointmentDto> getAllAppointments();
	Long countAddresses();
}
