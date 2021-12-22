package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService userService; // dependency injection

	@PostMapping("/user")
	@ResponseStatus(code = HttpStatus.CREATED)
	Integer createUser(@Valid @RequestBody User user) throws Exception {
		System.out.println(user.getName());
		System.out.println(user.getAge());
		userService.save(user);
		return user.getId();
	}

	@DeleteMapping("/user/{id}")
	void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

	@PutMapping("/user/{id}")
	void updateUser(@RequestBody User user, @PathVariable Integer id) {
		userService.updateUser(user, id);
	}

	@GetMapping("/user")
	List<User> getAllUsers() {
		return userService.getAllUser();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	 Map<String, String> handleValidationException(MethodArgumentNotValidException exception) {
		Map<String, String> messages = new HashMap<>();
		exception.getAllErrors().forEach(error-> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			messages.put(fieldName, errorMessage);
		});
		return messages;
	}
}
