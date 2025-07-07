package com.khan.restful_web_services.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> findAll() {
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> findById(@PathVariable int id) {
		Optional<User> user = userDaoService.findById(id);
		
		if (user.isEmpty()) {			
			throw new UserNotFoundException("id:" + id);			
		}
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userDaoService.addUser(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		userDaoService.deleteById(id);
	}
}
