package com.cameron.waterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.waterBnB.models.Booking;

public interface BookingRepo extends CrudRepository<Booking, Long>{
	List<Booking> findAll();
}
