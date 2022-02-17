package com.cameron.students.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.students.models.Student;


public interface StudentRepo extends CrudRepository<Student, Long>{
	List<Student> findAll();
}
