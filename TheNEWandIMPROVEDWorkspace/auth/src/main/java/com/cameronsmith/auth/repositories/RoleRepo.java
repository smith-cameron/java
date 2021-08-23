package com.cameronsmith.auth.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.auth.models.Role;
@Repository
public interface RoleRepo extends CrudRepository<Role, Long>{
	List<Role> findByName(String string);
    List<Role> findAll();
}
