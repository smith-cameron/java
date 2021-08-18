package com.cameron.students.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.students.models.Student;
import com.cameron.students.repositories.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo sRepo;
	
	public Student create(Student newEntry) {
		return this.sRepo.save(newEntry);
	}
	public Student update(Student toUpdate) {
		return this.sRepo.save(toUpdate);
	}
	public List<Student> getAll(){
		return this.sRepo.findAll();
	}
	public Student getById(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.sRepo.deleteById(id);
	}
}
