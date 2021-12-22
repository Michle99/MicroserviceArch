package com.example.demo.entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotNull(message = "age is required")
	private Integer age;
	@NotNull(message = "salary is required")
	private Float salary;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Address> addresses;

	@OneToMany(mappedBy="user", cascade = CascadeType.ALL)
	private List<UserGroup> groups;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<UserGroup> getGroups() {
		return groups;
	}
	
	public void setGroups(List<UserGroup> groups){
		this.groups = groups;
	}
	// @OneToOne(cascade = CascadeType.ALL)
	// @JoinColumn(name="address_id", referencedColumnName = "id")
	// private Address address;


	

	// public Address getAddress() {
	// 	return address;
	// }

	// public void setAddress(Address address) {
	// 	this.address = address;
	// }


	

	public Integer getAge() {
		return age;
	}

	public Float getSalary() {
		return salary;
	}
	public void setSalary(Float salary){
		this.salary = salary;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public String getName() {
		return name;
	}

//	@UniqueConstraint(columnNames = "name")
	public void setName(String name) {
		this.name = name;
	}
}
