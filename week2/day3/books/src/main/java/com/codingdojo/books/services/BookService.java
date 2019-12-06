package com.codingdojo.books.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public Book findBookById(Long id) {
		Optional<Book> maybeBook = bookRepo.findById(id);
		
		if (maybeBook.isPresent()) {
			return maybeBook.get();
		}
		
		return null;
	}
	
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}
}
