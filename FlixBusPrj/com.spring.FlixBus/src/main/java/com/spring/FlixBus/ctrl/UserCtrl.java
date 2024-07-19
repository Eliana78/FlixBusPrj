package com.spring.FlixBus.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.FlixBus.entities.User;

import com.spring.FlixBus.service.UserService;

@RestController
@RequestMapping("/api")
public class UserCtrl {

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	@CrossOrigin
	List<User> getUsers(){
		return userService.getUsers();
	};
	
	

    @GetMapping("/users/id/{id}")
    @CrossOrigin
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> userOptional = userService.getUserById(id);
        
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
    
    @PostMapping("/users/add")
	public User addUser(@RequestBody User u) {
    	return userService.addUser(u);
    }
	
	
    
    @PostMapping("/users/update")
    @CrossOrigin
    public User updateUser(@RequestBody User u) {
        return userService.updateUser(u);
    }
    
    
    
    @PostMapping("/users/delete")
    @CrossOrigin
    public void deleteUser(@RequestBody User u) {
        userService.deleteUser(u);
    }
    
    
    
    
    @GetMapping("/users/email/{email}")
    @CrossOrigin
    public ResponseEntity<User> getByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.getByEmail(email);
        
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	
	
	
}
