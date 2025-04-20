package com.dams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dams.dto.UsersDto;
import com.dams.enumformodel.Gender;
import com.dams.enumformodel.Role;
import com.dams.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	// Create
	@PostMapping("/create")
	public ResponseEntity<UsersDto> creatUser(@RequestBody UsersDto userDto) {
		UsersDto user = this.userService.createUser(userDto);
		return new ResponseEntity<UsersDto>(user, HttpStatus.CREATED);
	}

	@PutMapping("/update/{userId}")
	public ResponseEntity<UsersDto> updateUser(@RequestBody UsersDto userDto, Long userId) {
		UsersDto user = this.userService.updateUser(userDto, userId);
		return new ResponseEntity<UsersDto>(user, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<Boolean> deleteUserById(@PathVariable Long userId) {
		return new ResponseEntity<Boolean>(
				this.userService.deleteUserById(userId), HttpStatus.OK);
	}

	// GetUserById
	@GetMapping("/{userId}")
	public ResponseEntity<UsersDto> getUserById(@PathVariable Long userId) {
		return ResponseEntity.ok(
				this.userService.getUserById(userId));
	}
	// GetAllUsers
	@GetMapping("/")
	public ResponseEntity<List<UsersDto>> getAllUsers() {
		return ResponseEntity.ok(
				this.userService.getAllUsers());
	}
	@GetMapping("/admins")
	public ResponseEntity<List<UsersDto>> getAllAdmin() {
		return ResponseEntity.ok(
				this.userService.getUsersByRole(Role.ADMIN));
	}
	@GetMapping("/maleadmins")
	public ResponseEntity<List<UsersDto>> getAllMaleAdmin() {
		return ResponseEntity.ok(
				this.userService.getUsersByGenderAndRole(Gender.MALE, Role.ADMIN));
	}
	@GetMapping("/femaleadmins")
	public ResponseEntity<List<UsersDto>> getAllFeMaleAdmin() {
		return ResponseEntity.ok(
				this.userService.getUsersByGenderAndRole(Gender.FEMALE, Role.ADMIN));
	}

	@GetMapping("/doctors")
	public ResponseEntity<List<UsersDto>> getAllDoctors() {
		return ResponseEntity.ok(
				this.userService.getUsersByRole(Role.DOCTOR));
	}
	@GetMapping("/maledoctors")
	public ResponseEntity<List<UsersDto>> getAllMaleDoctors() {
		return ResponseEntity.ok(
				this.userService.getUsersByGenderAndRole(Gender.MALE, Role.DOCTOR));
	}
	@GetMapping("/femaledoctors")
	public ResponseEntity<List<UsersDto>> getAllFeMaleDoctors() {
		return ResponseEntity.ok(
				this.userService.getUsersByGenderAndRole(Gender.FEMALE, Role.DOCTOR));
	}

	// CountUser
	@GetMapping("/count") 
	public ResponseEntity<Long> countUser() { 
		return  ResponseEntity.ok(
				this.userService.countAllUsers());
	}

	@GetMapping("/count-admin")
	public ResponseEntity<Long> countAdmin() {
		return ResponseEntity.ok(
				this.userService.countUsersByRole(Role.ADMIN));
	}

	@GetMapping("/count-doctor")
	public ResponseEntity<Long> countDoctor() {
		return ResponseEntity.ok(
				this.userService.countUsersByRole(Role.DOCTOR));
	}

	@GetMapping("/count-maledoctor")
	public ResponseEntity<Long> countMaleDoctor() {
		return ResponseEntity.ok(
				this.userService.countUsersByGenderAndRole(Gender.MALE, Role.DOCTOR));
	}

	@GetMapping("/count-femaledoctor")
	public ResponseEntity<Long> countFemaleDoctor() {
		return ResponseEntity.ok(
				this.userService.countUsersByGenderAndRole(Gender.FEMALE, Role.DOCTOR));
	}

}
