package com.cameron.passGenerator.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameron.passGenerator.models.Password;

@Repository
public interface PasswordRepo extends CrudRepository <Password, Long>{
	List<Password> findAll();
	Password save(String newEntry);
}
