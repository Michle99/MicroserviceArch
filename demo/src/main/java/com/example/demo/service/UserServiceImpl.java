package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	UserRepository repository;

	@Override
	public String save(User user) {
		System.out.println(user.getAge());
		repository.save(user);
		return user.getName();
	}
}
