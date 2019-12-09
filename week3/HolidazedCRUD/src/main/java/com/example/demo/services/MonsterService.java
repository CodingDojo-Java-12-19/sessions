package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.models.Monster;
import com.example.demo.models.User;
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
	public void delete(Long id) {
		this.mRepo.deleteById(id);
	}
	public Monster create(Monster monster) {
		return this.mRepo.save(monster);
	}
	public Monster update(Monster monster) {
		return this.mRepo.save(monster);
	}
	public Monster likeUser(Monster monster, User user) {
		// grab list of likedUsers from the monster
		List<User> users = monster.getUserLikes();
		// TODO: see if user already liked it!
		if(!users.contains(user)) {
			users.add(user);
		}
		
		// update the monster with the new list (call the setter)
		monster.setUserLikes(users);
		
		// finally, save it!
		return this.mRepo.save(monster);
	}
	public Monster dislikeUser(Monster monster, User user) {
		// grab list of likedUsers from the monster
		List<User> users = monster.getUserLikes();
		
		// remove the user
		users.remove(user);
		
		// finally, save it!
		return this.mRepo.save(monster);
	}
}
