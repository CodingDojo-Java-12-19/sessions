package com.codingdojo.books.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.books.models.Book;
import com.codingdojo.books.services.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("")
	public String index(Model viewModel) {
		List<Book> books = bookService.findAll();
		
		viewModel.addAttribute("books", books);
		
		System.out.println("Got books! " + books.size());
		
		return "/books/index.jsp";
	}
	
	// /books
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		
		if (result.hasErrors()) {
			// do something else
			
			return "books/new.jsp";
		}
		
		System.out.println("book title " + book.getTitle().length());
		System.out.println("publisher  " + book.getPublisher());
		System.out.println("pages " + book.getPages() );
		
		bookService.createBook(book);
		
		return "redirect:/books";
	}
	
	@GetMapping("/new")
	public String newBook(@ModelAttribute("book") Book book) {
		return "books/new.jsp";
	}
	
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		Book book = bookService.findBookById(id);
		
		System.out.println("book title " + book.getTitle());
		System.out.println("publisher  " + book.getPublisher());
		System.out.println("pages " + book.getPages() );
		
		viewModel.addAttribute("book", book);

		
		return "";
	}
	
	
}
