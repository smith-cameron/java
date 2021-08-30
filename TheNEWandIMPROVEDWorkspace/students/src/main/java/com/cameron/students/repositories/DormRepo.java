package com.cameron.students.repositories;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.cameron.students.models.Dorm;

public interface DormRepo extends CrudRepository<Dorm, Long>{
	List<Dorm> findAll();
}
