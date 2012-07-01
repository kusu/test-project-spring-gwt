package com.me.testproject.server.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.me.testproject.server.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query("select u from User u where u.userName=?1")
	User findByUserName(String username);

	@Query("select u from User u where u.deleted=false and u.disabled=false")
	List<User> findAllUsers();
}
