package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Ability;

public interface AbilityRepository extends CrudRepository<Ability, Long>{
	List<Ability> findAll();
}
