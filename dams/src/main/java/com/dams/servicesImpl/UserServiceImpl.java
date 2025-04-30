package com.dams.servicesImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dams.dto.UsersDto;
import com.dams.enumformodel.Gender;
import com.dams.enumformodel.Role;
import com.dams.exception.ResourceNotFoundException;
import com.dams.model.Users;
import com.dams.repository.UserRepository;
import com.dams.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;



	@Override
	public UsersDto createUser(UsersDto userDto) {
		Users user = this.modelMapper.map(userDto, Users.class);
		Users savedUser = this.userRepo.save(user);
		return this.modelMapper.map(savedUser, UsersDto.class);
	}

	@Override
	public UsersDto updateUser(UsersDto userDto, Long userId) {
		Users user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		user.setFName(userDto.getFName());
		user.setLName(userDto.getLName());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());
		user.setGender(userDto.getGender());
		user.setUserRole(userDto.getUserRole());
		user.setPassword(userDto.getPassword());
		user.setUpdatedAt(LocalDateTime.now());
		Users updatedUser = this.userRepo.save(user);
		return this.modelMapper.map(updatedUser, UsersDto.class);
	}
	
	@Override
	public boolean deleteUserById(Long userId) {
		Users user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		this.userRepo.delete(user);
		return true;
	}

	@Override
	public UsersDto getUserById(Long userId) {
		Users user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "ID", userId));
		return this.modelMapper.map(user, UsersDto.class);
	}

	@Override
	public List<UsersDto> getAllUsers() {
		List<Users> users = this.userRepo.findAll();
		return users.stream().map(user -> 
		this.modelMapper.map(users, UsersDto.class)).collect(Collectors.toList());
	}

	@Override
	public UsersDto getUserByEmail(String email) {
		Users user = this.userRepo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("user", "Email", email));
		return this.modelMapper.map(user, UsersDto.class);
	}

	@Override
	public UsersDto getUserByPhone(String phoneNo) {
		Users user = this.userRepo.findByPhone(phoneNo)
				.orElseThrow(() -> new ResourceNotFoundException("user", "Phone", phoneNo));
		return this.modelMapper.map(user, UsersDto.class);
	}

	@Override
	public List<UsersDto> getUsersByRole(Role role) {
		List<Users> allUsers = this.userRepo.findAllByRole(role);
		return allUsers.stream().map(user -> 
		this.modelMapper.map(allUsers, UsersDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<UsersDto> getUsersByGender(Gender gender) {
		List<Users> allUsers = this.userRepo.findAllByGender(gender);
		return allUsers.stream().map(user -> 
		this.modelMapper.map(allUsers, UsersDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<UsersDto> getUsersByGenderAndRole(Gender gender, Role role) {
		List<Users> allUsers =this.userRepo.findAllByGenderAndRole(gender, role);
		return allUsers.stream().map(user ->
		this.modelMapper.map(allUsers, UsersDto.class)).collect(Collectors.toList());
	}

	@Override
	public Long countUsersByRole(Role role) {
		return userRepo.countByRole(role);
	}

	@Override
	public Long countUsersByGenderAndRole(Gender gender, Role role) {
		return userRepo.countByGenderAndRole(gender, role);
	}

	@Override
	public Long countAllUsers() {
		return this.userRepo.count();
	}

	/*
	 * @Override public UsersDto updateUserPassword(PasswordChangeRequestDto
	 * pcRequestDto, Long userId) { Users user =
	 * userRepo.findById(userId).orElseThrow(() -> new
	 * ResourceNotFoundException("User", "ID", userId));
	 * 
	 * // You should hash the password before saving it //String encodedPassword =
	 * passwordEncoder.encode(pcRequestDto.getPassword());
	 * //user.setPassword(encodedPassword);
	 * user.setPassword(pcRequestDto.getPassword());
	 * user.setUpdatedAt(LocalDateTime.now());
	 * 
	 * Users updatedUser = userRepo.save(user); return modelMapper.map(updatedUser,
	 * UsersDto.class); }
	 */
	
	/*
	 * public UsersDto partialUpdate(Long userId, Map<String, Object> updates) {
	 * Users user = userRepo.findById(userId) .orElseThrow(() -> new
	 * ResourceNotFoundException("User", "ID", userId));
	 * 
	 * updates.forEach((key, value) -> { Field field =
	 * ReflectionUtils.findField(Users.class, key); if (field != null) {
	 * field.setAccessible(true); ReflectionUtils.setField(field, user, value); }
	 * });
	 * 
	 * Users updatedUser = userRepo.save(user); return
	 * modelMapper.toDto(updatedUser); }
	 */

}
