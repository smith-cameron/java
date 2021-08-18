package com.cameron.loginAndReg.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameron.loginAndReg.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
	List<User> findAll();
	//Query for ordering messages by likes

	boolean existsByEmail(String email);
}
