package com.cameron.students.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.students.models.Stack;

public interface StackRepo extends CrudRepository<Stack, Long>{
	List<Stack> findAll();
}
