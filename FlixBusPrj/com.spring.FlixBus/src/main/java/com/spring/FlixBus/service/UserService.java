package com.spring.FlixBus.service;



import java.util.List;
import java.util.Optional;

import com.spring.FlixBus.entities.User;



public interface UserService {
	
	
	List<User> getUsers();
	Optional<User> getUserById(int id);
	User addUser(User u);
	User updateUser(User u);
	void deleteUser(User u);
	Optional<User> getByEmail(String email);
	
	
}
