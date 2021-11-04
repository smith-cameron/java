package com.cameron.waterBnB.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameron.waterBnB.models.Booking;
import com.cameron.waterBnB.repositories.BookingRepo;
@Service
public class BookingService {
	@Autowired
	private BookingRepo bRepo;
	
	public Booking createEntry(Booking newEntry) {
		return this.bRepo.save(newEntry);
	}
	public Booking updateEntry(Booking toUpdate) {
		return this.bRepo.save(toUpdate);
	}
	public List<Booking> getAll(){
		return this.bRepo.findAll();
	}
	public Booking getById(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.bRepo.deleteById(id);
	}
}
