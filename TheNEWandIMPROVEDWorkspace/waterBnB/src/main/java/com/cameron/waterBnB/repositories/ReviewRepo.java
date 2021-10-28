package com.cameron.waterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.waterBnB.models.Review;

public interface ReviewRepo extends CrudRepository<Review, Long>{
	List<Review> findAll();
}
