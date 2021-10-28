package com.cameron.waterBnB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.waterBnB.models.Message;
import com.cameron.waterBnB.repositories.MessageRepo;

@Service
public class MessageService {
	@Autowired
	private MessageRepo mRepo;
	
	public Message createEntry(Message newEntry) {
		return this.mRepo.save(newEntry);
	}
	public Message updateEntry(Message toUpdate) {
		return this.mRepo.save(toUpdate);
	}
	public List<Message> getAll(){
		return this.mRepo.findAll();
	}
	public Message getById(Long id) {
		return this.mRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.mRepo.deleteById(id);
	}
}
