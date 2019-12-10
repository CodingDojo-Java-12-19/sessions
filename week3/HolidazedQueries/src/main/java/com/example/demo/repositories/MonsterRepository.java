package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Monster;

public interface MonsterRepository extends CrudRepository<Monster, Long>{
	List<Monster> findAll();
	List<Monster> findByDescriptionContaining(String search);
	List<Monster> findByNameContaining(String name);
	
	// select m.name, SUM(a.power_level) AS total_power FROM monsters AS m LEFT JOIN abilities AS a ON m.id = a.monster_id GROUP BY a.monster_id ORDER BY total_power DESC;
	@Query("SELECT m, SUM(a.powerLevel) AS total_power FROM Monster m LEFT JOIN m.abilities a GROUP BY m.id ORDER BY total_power DESC")
	List<Monster> findAllOrderByTotalPower();
}
