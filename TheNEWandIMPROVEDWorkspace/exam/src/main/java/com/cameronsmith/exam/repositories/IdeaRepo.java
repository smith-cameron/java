package com.cameronsmith.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.exam.models.Idea;

public interface IdeaRepo extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
	@Query("SELECT i FROM Idea i Order By i.likers.size DESC")
	List<Idea> orderByDesc();
	@Query("SELECT i FROM Idea i Order By i.likers.size ASC")
	List<Idea> orderByAsc();
	
	
	
//	List<Idea> findAllByLikersOrderByAllAsc();
//	List<Idea> findAllByLikersOrderByAllDesc();
}