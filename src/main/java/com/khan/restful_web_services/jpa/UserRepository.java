package com.khan.restful_web_services.jpa;

import com.khan.restful_web_services.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepository extends JpaRepository<User, Integer> {
}
