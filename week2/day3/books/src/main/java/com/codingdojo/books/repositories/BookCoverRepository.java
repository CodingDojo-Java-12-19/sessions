package com.codingdojo.books.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.books.models.BookCover;


@Repository
public interface BookCoverRepository extends CrudRepository<BookCover, Long>{
	List<BookCover> findAll();

}
