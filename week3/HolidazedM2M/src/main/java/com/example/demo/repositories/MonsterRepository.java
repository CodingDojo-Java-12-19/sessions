package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Monster;

public interface MonsterRepository extends CrudRepository<Monster, Long>{
	List<Monster> findAll();
	List<Monster> findByDescriptionContaining(String search);
}
