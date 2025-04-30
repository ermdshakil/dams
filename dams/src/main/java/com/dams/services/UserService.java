package com.dams.services;

import java.util.List;

import com.dams.dto.PasswordChangeRequestDto;
import com.dams.dto.UsersDto;
import com.dams.enumformodel.Gender;
import com.dams.enumformodel.Role;

public interface UserService {

	boolean deleteUserById(Long id);

	UsersDto createUser(UsersDto userDto);

	UsersDto updateUser(UsersDto userDto, Long userId);
	//UsersDto updateUserPassword(PasswordChangeRequestDto pcRequestDto, Long userId);
	UsersDto getUserById(Long id);

	UsersDto getUserByEmail(String email);

	UsersDto getUserByPhone(String phoneNo);
	
	List<UsersDto> getAllUsers();

	List<UsersDto> getUsersByRole(Role role);

	List<UsersDto> getUsersByGender(Gender gender);

	List<UsersDto> getUsersByGenderAndRole(Gender gender, Role role);
	
	Long countAllUsers();
	
	Long countUsersByRole(Role role);

	Long countUsersByGenderAndRole(Gender gender, Role role);
}

/*
 * UsersDto createUser(UsersDto userDto); UsersDto updateUser(UsersDto userDto,
 * Long userId); boolean deleteUserById(Long userId); List<UsersDto>
 * getAllUsers(); List<UsersDto> getAllUsersByGender(Gender gender);
 * List<UsersDto> getAllUserByRole(Role role); UsersDto getUserById(Long
 * userId); Long countTotalUsers(); Long countDoctors(); Long countAdmins();
 */
