package com.example.demo.entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
@Table(name="usergroup")
public class UserGroup {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @NotBlank(message = "Name is mandatory")
    private String name;

    @ManyToOne
	@JoinColumn(name="user_id")
	private User user;

    //deserialization
    public UserGroup(){} 

    public UserGroup(String name){
        this.name = name;
    }

	public User getUser(){
		return user;
	}
	public void setUser(User user){
		this.user = user;
	}

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
