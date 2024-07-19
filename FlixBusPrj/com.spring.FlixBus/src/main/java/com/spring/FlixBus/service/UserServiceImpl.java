package com.spring.FlixBus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.FlixBus.entities.User;
import com.spring.FlixBus.repo.UserRepo;

import ExceptionsHandling.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public List<User> getUsers() {
		
		return userRepo.findAll();
	}

	@Override
	public Optional<User> getUserById(int id) {
		
		return userRepo.findById(id);
	}

	@Override
	public User addUser(User u) {
		
		return userRepo.save(u);
	}

	@Override
	public User updateUser(User u) {
		
		return  userRepo.save(u);
	}

	@Override
	public void deleteUser(User u) {
		   if (u == null || u.getId() == null) {
	            throw new IllegalArgumentException("User or User ID must not be null");
	        }
	        
	        Optional<User> existingUser = userRepo.findById(u.getId());
	        if (existingUser.isPresent()) {
	            userRepo.delete(u);
	        } else {
	            throw new UserNotFoundException("User with id " + u.getId() + " not found");
	        }
	    }
		
	

	@Override
	public Optional<User> getByEmail(String email) {
		
		return userRepo.findByEmail(email);
	}
	
	
	

}
