package com.khan.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<User>();
	private static int usersCount = 0;
	
	static {
		users.add(new User(++usersCount, "Abul", LocalDate.now().minusYears(30)));
		users.add(new User(++usersCount, "Babul", LocalDate.now().minusYears(50)));
		users.add(new User(++usersCount, "Kabul", LocalDate.now().minusYears(25)));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public Optional<User> findById(int id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst();
	}
	
	public User addUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		users.removeIf(user -> user.getId().equals(id));
	}
}
