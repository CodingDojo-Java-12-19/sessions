package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Monster;

public interface MonsterRepository extends JpaRepository<Monster, Long>{
	List<Monster> findByDescriptionContaining(String search);
	List<Monster> findByNameContaining(String name);
	List<Monster> findByOrderByName();
	List<Monster> findByOrderByLocation();
//	List<Monster> findByOrderByUserLikes();
	
	// select m.name, SUM(a.power_level) AS total_power FROM monsters AS m LEFT JOIN abilities AS a ON m.id = a.monster_id GROUP BY a.monster_id ORDER BY total_power DESC;
	@Query("SELECT m, SUM(a.powerLevel) AS total_power FROM Monster m LEFT JOIN m.abilities a GROUP BY m.id ORDER BY total_power DESC")
	List<Monster> findAllOrderByTotalPower();
}
