package com.cameron.waterBnB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.waterBnB.models.Review;
import com.cameron.waterBnB.repositories.ReviewRepo;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepo rRepo;
	
	public Review createEntry(Review newEntry) {
		return this.rRepo.save(newEntry);
	}
	public Review updateEntry(Review toUpdate) {
		return this.rRepo.save(toUpdate);
	}
	public List<Review> getAll(){
		return this.rRepo.findAll();
	}
	public Review getById(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.rRepo.deleteById(id);
	}
}
