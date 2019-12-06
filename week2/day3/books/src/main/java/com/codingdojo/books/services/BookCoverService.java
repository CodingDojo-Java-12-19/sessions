package com.codingdojo.books.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.books.models.BookCover;
import com.codingdojo.books.repositories.BookCoverRepository;

@Service
public class BookCoverService {
	private BookCoverRepository bcRepo;

	public BookCoverService(BookCoverRepository bcRepo) {
		this.bcRepo = bcRepo;
	}
	
	public List<BookCover> getAllCovers() {
		return this.bcRepo.findAll();
	}
	
	public BookCover create(BookCover cover) {
		return this.bcRepo.save(cover);
	}
}
