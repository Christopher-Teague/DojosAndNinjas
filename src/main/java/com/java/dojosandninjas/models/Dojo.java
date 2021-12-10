package com.java.dojosandninjas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    	private Long id;
    
    @NotNull
    @Size(min=2, message="name must be at least 2 characters long")
    private String name;
   
    
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    
    public Dojo() {}


	// ***** DB TABLE VARIABLES *****
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date createdAt;
	
	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private Date updatedAt;
	
	
	@PrePersist
	protected void onCreated() {
		this.createdAt = new Date();
	}
		
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}

	// SETTERS and GETTERS \\

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

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
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

    
}