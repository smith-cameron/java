package com.cameron.waterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.waterBnB.models.Listing;

public interface ListingRepo extends CrudRepository<Listing, Long>{
	List<Listing> findAll();
}
