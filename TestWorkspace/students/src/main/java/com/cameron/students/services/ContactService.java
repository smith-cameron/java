package com.cameron.students.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.students.models.Contact;
import com.cameron.students.models.Student;
import com.cameron.students.repositories.ContactRepo;

@Service
public class ContactService {
	@Autowired
	private ContactRepo cRepo;
	
	public Contact create(Contact newEntry) {
		return this.cRepo.save(newEntry);
	}
	public Contact update(Contact toUpdate) {
		return this.cRepo.save(toUpdate);
	}
	public List<Contact> getAll(){
		return this.cRepo.findAll();
	}
	public Contact getById(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.cRepo.deleteById(id);
	}
	public Contact getByStudent(Student s) {
		return this.cRepo.findAllByStudent(s);
	}
}
