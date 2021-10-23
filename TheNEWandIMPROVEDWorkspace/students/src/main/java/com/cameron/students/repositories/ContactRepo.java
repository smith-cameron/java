package com.cameron.students.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameron.students.models.Contact;
import com.cameron.students.models.Student;

@Repository
public interface ContactRepo extends CrudRepository<Contact, Long>{
	List<Contact> findAll();
	Contact findAllByStudent(Student student);
}
