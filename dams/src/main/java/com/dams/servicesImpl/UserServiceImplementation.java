package com.dams.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dams.dto.UsersDto;
import com.dams.enumformodel.Role;
import com.dams.model.Users;
import com.dams.repository.UserRepository;
import com.dams.services.UserService;

@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepo;
	@Override
	public UsersDto createUser(UsersDto userdto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsersDto updateUser(UsersDto userdto, Long userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteUser(Long userid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UsersDto> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long save() {
		        UsersDto user = new UsersDto();
		        user.setFName("Noor");
		        user.setLName("Ali");
		        user.setEmail("n@gmail.com");
		        user.setPhone("8079860185");
		        user.setPassword("Shakil01");
		        user.setUserRole(Role.DOCTOR);

		        Users u = new Users();
		        u.setFName(user.getFName());
		        u.setLName(user.getLName());
		        u.setEmail(user.getEmail());
		        u.setPhone(user.getPhone());
		        u.setPassword(user.getPassword());
		        u.setUserRole(user.getUserRole());

		        userRepo.save(u);
		        
		        System.out.print(u);
		        return u.getUserId();
		    }
}
