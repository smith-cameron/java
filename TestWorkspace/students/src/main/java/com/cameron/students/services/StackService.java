package com.cameron.students.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cameron.students.models.Stack;
import com.cameron.students.repositories.StackRepo;

public class StackService {
	@Autowired
	private StackRepo clRepo;
	
	public Stack create(Stack newEntry) {
		return this.clRepo.save(newEntry);
	}
	public Stack update(Stack toUpdate) {
		return this.clRepo.save(toUpdate);
	}
	public List<Stack> getAll(){
		return this.clRepo.findAll();
	}
	public Stack getById(long id) {
		return this.clRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.clRepo.deleteById(id);
	}
}
