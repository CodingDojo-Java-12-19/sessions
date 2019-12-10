package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="abilities")
public class Ability {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Size(min=2)
	private String name;
	// description String
	@Size(min=2, max=40)
	private String description;
	private Integer powerLevel;
	private Boolean isFatal;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="monster_id")
	private Monster monster;
	
	public Ability() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPowerLevel() {
		return powerLevel;
	}
	public void setPowerLevel(Integer powerLevel) {
		this.powerLevel = powerLevel;
	}
	public Boolean getIsFatal() {
		return isFatal;
	}
	public void setIsFatal(Boolean isFatal) {
		this.isFatal = isFatal;
	}
	public Monster getMonster() {
		return monster;
	}
	public void setMonster(Monster monster) {
		this.monster = monster;
	}
	
}
