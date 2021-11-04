package com.cameron.waterBnB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.waterBnB.models.Listing;
import com.cameron.waterBnB.repositories.ListingRepo;

@Service
public class ListingService {
	@Autowired
	private ListingRepo lRepo;
	
	public Listing createEntry(Listing newEntry) {
		return this.lRepo.save(newEntry);
	}
	public Listing updateEntry(Listing toUpdate) {
		return this.lRepo.save(toUpdate);
	}
	public List<Listing> getAll(){
		return this.lRepo.findAll();
	}
	public Listing getById(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.lRepo.deleteById(id);
	}
}
