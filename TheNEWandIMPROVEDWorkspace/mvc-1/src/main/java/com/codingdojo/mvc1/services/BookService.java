package com.codingdojo.mvc1.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc1.models.Book;
import com.codingdojo.mvc1.repositories.BookRepo;

@Service
public class BookService {
    // adding the book repository as a dependency/OLD WAY
//    private final BookRepo bookRepository;
//    
//    public BookService(BookRepo bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//	NEW WAY
	@Autowired
	private BookRepo bookRepository;
	
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book/OLD WAY
//    public Book findBookByIdOLD(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//        if(optionalBook.isPresent()) {
//            return optionalBook.get();
//        } else {
//            return null;
//        }
//    }
    // retrieves a book/NEW WAY
    public Book getByIdNEW(Long id) {
		return this.bookRepository.findById(id).orElse(null);
	}
	public Book updateBook(Long id, String title, String desc, String lang, Integer pages) {
		Book thisBook = this.bookRepository.findAllById(id);
		thisBook.setTitle(title);
		thisBook.setDescription(desc);
		thisBook.setLanguage(lang);
		thisBook.setPages(pages);
		return this.bookRepository.save(thisBook);
	}
	public void deleteBook(Long id) {
		this.bookRepository.deleteById(id);
		
	}
	public Book updateBook(Book objectToUpdate) {
		return this.bookRepository.save(objectToUpdate);
	}
}
