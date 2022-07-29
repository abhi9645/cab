package com.LibManag.lib.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LibManag.lib.model.User;
import com.LibManag.lib.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceimpl implements UserService {

    @Autowired
    UserRepository userRepository;

	@Override
	public List<User> getallstudenets() {
		// TODO Auto-generated method stub
		List<User> user=userRepository.findAll();
		return user;
	}


	@Override
	public User adduser(User user) {
		// TODO Auto-generated method stub
		System.out.println("hey");
		return userRepository.save(user);
	}


	@Override
	public User updateuser(User user, int id) {
		// TODO Auto-generated method stub
		Optional<User> user1 = userRepository.findById(id);
		
		if(user1 !=null) {
			User userUpdate =user1.get();
			System.out.println(userUpdate);
			userUpdate.setX(user.getX());
			userUpdate.setY(user.getY());
			
			return userRepository.save(userUpdate);
		}
		return null;
	}



}





	
	


