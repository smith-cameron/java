package com.cameron.loginAndReg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.loginAndReg.models.User;
import com.cameron.loginAndReg.repositories.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo uRepo;
	
	public User create(User newEntry) {
		return this.uRepo.save(newEntry);
	}
	public User update(User toUpdate) {
		return this.uRepo.save(toUpdate);
	}
	public List<User> getAll(){
		return this.uRepo.findAll();
	}
	public User getById(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.uRepo.deleteById(id);
	}

}
