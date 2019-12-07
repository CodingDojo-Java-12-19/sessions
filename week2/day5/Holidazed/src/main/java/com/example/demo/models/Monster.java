package com.example.demo.models;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="monsters")
public class Monster {
	// id Long
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// name String
	// bt 2 - 20
	@Size(min=2)
	private String name;
	// description String
	@Size(min=2, max=40)
	private String description;
	// location String
	@Size(min=2, max=20)
	private String location;
	@OneToMany(mappedBy="monster", fetch = FetchType.LAZY)
	private List<Ability> abilities;
	
	public Monster() {
		
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	
}
