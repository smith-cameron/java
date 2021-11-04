package com.cameronsmith.mvc.bookrepositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cameronsmith.mvc.bookmodels.Book;

@Repository
public interface BookRepo extends CrudRepository<Book,Long>{
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
    Long countByTitleContaining(String search);
    Long deleteByTitleStartingWith(String search);
}
