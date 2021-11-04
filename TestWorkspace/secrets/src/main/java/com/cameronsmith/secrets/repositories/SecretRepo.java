package com.cameronsmith.secrets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cameronsmith.secrets.models.Secret;

public interface SecretRepo extends CrudRepository<Secret, Long>{
	List<Secret> findAll();
	List<Secret> findFirst10ByOrderByCreatedAtDesc();
	@Query("SELECT s FROM Secret s Order By s.usersWhoLike.size DESC")
	List<Secret> findAllByOrderByAllLikesDesc();
}
