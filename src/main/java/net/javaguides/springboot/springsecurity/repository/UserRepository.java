package net.javaguides.springboot.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.web.dto.UserLoginDto;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	
	

	
	
}
