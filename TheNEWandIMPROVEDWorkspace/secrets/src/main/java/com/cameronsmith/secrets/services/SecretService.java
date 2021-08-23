package com.cameronsmith.secrets.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cameronsmith.secrets.models.Secret;
import com.cameronsmith.secrets.models.User;
import com.cameronsmith.secrets.repositories.SecretRepo;

@Service
public class SecretService {
	@Autowired
	private SecretRepo sRepo;
	
	public Secret createEntry(Secret newEntry) {
		return this.sRepo.save(newEntry);
	}
	public List<Secret> getAll(){
		return this.sRepo.findAll();
	}
	public Secret getEntryById(Long id) {
		return this.sRepo.findById(id).orElse(null);
	}
	public void deleteById(Long id) {
		this.sRepo.deleteById(id);
	}
	public List<User> getUsersWhoLike(){
		return this.getUsersWhoLike();
	}
	public void likeSecret(Secret secret, User user) {
		List<User> usersWhoLike = secret.getUsersWhoLike();
		usersWhoLike.add(user);
		this.sRepo.save(secret);
	}
	public void unlikeSecret(Secret secret, User user) {
		List<User> usersAttending = secret.getUsersWhoLike();
		usersAttending.remove(user);
		this.sRepo.save(secret);
	}
	public List<Secret> recentSecrets(){
		List<Secret> recent = this.sRepo.findFirst10ByOrderByCreatedAtDesc();
		return recent;
	}
	public List<Secret> secretsByLikes(){
		List<Secret> popular = this.sRepo.findAllByOrderByAllLikesDesc();
		return popular;
	}
}
