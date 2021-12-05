package com.cameronsmith.exam.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.exam.models.Idea;

public interface IdeaRepo extends CrudRepository<Idea, Long> {
	List<Idea> findAll();
	@Query("SELECT i FROM Idea i Order By i.usersWhoLike.size DESC")
	List<Idea> findAllByOrderByAllLikesDesc();
	@Query("SELECT i FROM Idea i Order By i.usersWhoLike.size ASC")
	List<Idea> findAllByOrderByAllLikesAsc();
	
}