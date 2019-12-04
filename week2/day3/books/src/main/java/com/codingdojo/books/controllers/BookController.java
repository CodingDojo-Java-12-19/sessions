package com.codingdojo.books.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
		
		return "";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String create(@RequestParam("title") String title, @RequestParam("pages") int pages) {
		Book book = new Book();
		
		book.setTitle(title);
		book.setPages(pages);
		
		bookService.createBook(book);
		
		return "redirect:/books";
	}
}
