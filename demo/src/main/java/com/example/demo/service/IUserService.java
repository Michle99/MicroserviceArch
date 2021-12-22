package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface IUserService {
	String save(User user) throws Exception;

	List<User> getAllUser();
	//2

	void updateUser(User user, Integer id);

	void deleteUser(Integer id);
}
