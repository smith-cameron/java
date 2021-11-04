package com.cameronsmith.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.auth.models.User;

@Repository
public interface UserRepo  extends CrudRepository<User, Long> {
    User findByUsername(String username);
    List<User> findAll();
}
