package com.example.demo.models;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
	@Size(min=2, max=100)
	private String description;
	// location String
	@Size(min=2, max=20)
	private String location;
	private Date createdAt;
	private Date updatedAt;
	@OneToMany(mappedBy="monster", fetch = FetchType.LAZY)
	private List<Ability> abilities;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_monsters", 
        joinColumns = @JoinColumn(name = "monster_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> userLikes;
	
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
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	public List<Ability> getAbilities() {
		return abilities;
	}
	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}
	public List<User> getUserLikes() {
		return userLikes;
	}
	public void setUserLikes(List<User> userLikes) {
		this.userLikes = userLikes;
	}
	
}
