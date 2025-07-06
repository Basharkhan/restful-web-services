package com.khan.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1, "Abul", LocalDate.now().minusYears(30)));
		users.add(new User(2, "Babul", LocalDate.now().minusYears(50)));
		users.add(new User(2, "Kabul", LocalDate.now().minusYears(25)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public Optional<User> findById(int id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst();
	}
}
