package com.f1soft.testproject.server.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.f1soft.testproject.server.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("select u from User u where u.userName=?1")
	User findByUserName(String username);
}
