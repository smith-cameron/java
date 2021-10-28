package com.cameron.waterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.waterBnB.models.User;

public interface UserRepo extends CrudRepository<User, Long>{
	List<User> findAll();
	boolean existsByEmail(String email);
	User findByEmail(String email);
}