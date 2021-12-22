package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	private String houseNumber;
	
	// @OneToOne(mappedBy = "address")
	// private User user;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Address() {}
	
	public Address (String houseNumber){
		this.houseNumber = houseNumber;
	}
	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
}
