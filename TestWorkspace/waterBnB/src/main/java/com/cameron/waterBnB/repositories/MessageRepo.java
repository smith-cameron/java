package com.cameron.waterBnB.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.waterBnB.models.Message;

public interface MessageRepo extends CrudRepository<Message, Long>{
	List<Message> findAll();
}
