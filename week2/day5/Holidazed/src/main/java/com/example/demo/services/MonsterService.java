package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Monster;
import com.example.demo.repositories.AbilityRepository;
import com.example.demo.repositories.MonsterRepository;

@Service
public class MonsterService {
	// dependancy injection!
	private MonsterRepository mRepo;
	private AbilityRepository aRepo;
	public MonsterService(MonsterRepository monsterRepo, AbilityRepository abilRepo) {
		this.mRepo = monsterRepo;
		this.aRepo = abilRepo;
	}
	public List<Monster> getAllMonsters() {
		return this.mRepo.findAll();
	}
	public Monster getOne(Long id) {
		return this.mRepo.findById(id).orElse(null);
	}
}
