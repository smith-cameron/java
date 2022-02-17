package com.cameronsmith.exam.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.exam.models.Idea;
import com.cameronsmith.exam.models.User;
import com.cameronsmith.exam.repositories.IdeaRepo;

@Service
public class IdeaService {
	@Autowired
	private IdeaRepo iRepo;
	
	public Idea createEntry(Idea input) {
		return this.iRepo.save(input);
	}
	public List<Idea> getAll(){
		return this.iRepo.findAll();
	}
	public Idea getById(Long id) {
		return this.iRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.iRepo.deleteById(id);
	}
	public void like(Idea idea, User user) {
		List<User> ideasLiked = idea.getUsersWhoLike();
		ideasLiked.add(user);
		this.iRepo.save(idea);
	}
	public void unlike(Idea idea, User user) {
		List<User> ideasLiked = idea.getUsersWhoLike();
		ideasLiked.remove(user);
		this.iRepo.save(idea);
	}
	public List<Idea> ideasByLikesDesc(){
		return this.iRepo.orderByDesc();
	}
	public List<Idea> ideasByLikesAsc(){
		return this.iRepo.orderByAsc();
	}
}
