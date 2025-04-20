/*
 * package com.dams.servicesImpl;
 * 
 * import java.lang.reflect.Type; import java.util.List; import
 * java.util.Optional; import java.util.stream.Collectors;
 * 
 * import org.modelmapper.ModelMapper; import org.modelmapper.TypeToken; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.dams.dto.UsersDto; import com.dams.enumformodel.Gender; import
 * com.dams.enumformodel.Role; import
 * com.dams.exception.ResourceNotFoundException; import com.dams.model.Users;
 * import com.dams.repository.UserRepository; import
 * com.dams.services.UserService;
 * 
 * @Service public class UserServiceImpl implements UserService {
 * 
 * @Autowired private UserRepository userRepo;
 * 
 * @Autowired private ModelMapper modelMapper;
 * 
 * @Override public UsersDto createUser(UsersDto userDto) { Users user =
 * this.modelMapper.map(userDto, Users.class); Users savedUser =
 * this.userRepo.save(user); return this.modelMapper.map(savedUser,
 * UsersDto.class); }
 * 
 * @Override public UsersDto updateUser(UsersDto userDto, Long userId) { Users
 * user = userRepo.findById(userId).orElseThrow(() -> new
 * ResourceNotFoundException("User", "ID", userId));
 * user.setFName(userDto.getFName()); user.setLName(userDto.getLName());
 * user.setEmail(userDto.getEmail()); user.setPhone(userDto.getPhone());
 * user.setGender(userDto.getGender()); user.setUserRole(userDto.getUserRole());
 * user.setPassword(userDto.getPassword());
 * user.setUpdatedAt(userDto.getUpdatedAt()); Users updatedUser =
 * this.userRepo.save(user); return this.modelMapper.map(updatedUser,
 * UsersDto.class); }
 * 
 * @Override public boolean deleteUserById(Long userId) { Users user =
 * this.userRepo.findById(userId) .orElseThrow(() -> new
 * ResourceNotFoundException("User", "ID", userId)); this.userRepo.delete(user);
 * return true; }
 * 
 * @Override public UsersDto getUserById(Long userId) { Users user =
 * this.userRepo.findById(userId) .orElseThrow(() -> new
 * ResourceNotFoundException("user", "ID", userId)); return
 * this.modelMapper.map(user, UsersDto.class); }
 * 
 * @Override public List<UsersDto> getAllUsers() { List<Users> users =
 * this.userRepo.findAll(); return users.stream().map(user ->
 * this.modelMapper.map(users, UsersDto.class)).collect(Collectors.toList()); }
 * 
 * @Override public List<UsersDto> getAllUsers() { List<Users> users =
 * this.userRepo.findAll(); Type listType = new TypeToken<List<UsersDto>>() {
 * }.getType(); return this.modelMapper.map(users, listType); }
 * 
 * @Override public List<UsersDto> getAllUsersByGender(Gender gender) {
 * List<Users> allUsers = ((Optional<Users>) this.userRepo.findByGender(gender)
 * 
 * .orElseThrow(() -> new ResourceNotFoundException("gender", "GENDER",
 * gender)); return null; }
 * 
 * @Override public Long countTotalUsers() { return this.userRepo.count(); }
 * 
 * @Override public Long countDoctors() { return this.userRepo.countDoctors(); }
 * 
 * @Override public Long countAdmins() { return this.userRepo.countAdmins(); }
 * 
 * @Override public List<UsersDto> getAllUserByRole(Role role) { // TODO
 * Auto-generated method stub return null; } }
 */