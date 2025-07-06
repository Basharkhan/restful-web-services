package com.khan.restful_web_services.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
		return userDaoService.findById(id);
	}
}
