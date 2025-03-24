package com.dams.services;

import java.util.List;

import com.dams.dto.UsersDto;

public interface UserService {
	
	UsersDto createUser(UsersDto userdto);
	UsersDto updateUser(UsersDto userdto, Long userid);
	int deleteUser(Long userid);
	List<UsersDto> getAllUsers();
	public Long countUser();
	
	public Long save();

}
